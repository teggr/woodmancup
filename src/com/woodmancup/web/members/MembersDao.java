package com.woodmancup.web.members;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;

/**
 * @author robin
 * 
 */
public class MembersDao {

	private final DatastoreService datastoreService = DatastoreServiceFactory
			.getDatastoreService();

	public Member saveMember(Member member) {
		Key membersEntityKey = getMembersEntityKey();
		Transaction txn = datastoreService.beginTransaction();
		try {
			Entity entity = createMemberEntity(member, membersEntityKey);
			datastoreService.put(entity);
			member.setKey(KeyFactory.keyToString(entity.getKey()));
			txn.commit();
		} finally {
			if (txn.isActive()) {
				txn.rollback();
			}
		}
		return member;
	}

	private Key getMembersEntityKey() {
		Key key;
		Transaction txn = datastoreService.beginTransaction();
		try {
			key = KeyFactory.createKey("Members", "members");
			Entity members = datastoreService.get(key);
			key = members.getKey();
		} catch (EntityNotFoundException e) {
			Entity entity = new Entity("Members", "members");
			key = datastoreService.put(entity);
		}
		txn.commit();
		return key;
	}

	private Entity createMemberEntity(Member member, Key membersEntityKey) {

		Entity entity = new Entity("Member", membersEntityKey);
		if (member.getKey() != null) {
			Key key = KeyFactory.stringToKey(member.getKey());
			entity = new Entity(key);
		}
		entity.setProperty("firstName", member.getFirstName());
		entity.setProperty("surname", member.getSurname());
		entity.setProperty("nicknames", member.getNicknames());
		entity.setProperty("description", member.getDescription());
		entity.setProperty("profilePictureUrl", member.getProfilePictureUrl());
		return entity;
	}

	public List<Member> getAll() {
		List<Member> list = new ArrayList<Member>();
		Query query = new Query("Member").setAncestor(getMembersEntityKey());
		PreparedQuery prepare = datastoreService.prepare(query);
		for (Entity result : prepare.asIterable()) {
			list.add(createMember(result));
		}
		return list;
	}

	private Member createMember(Entity entity) {
		Member member = new Member();
		member.setFirstName((String) entity.getProperty("firstName"));
		member.setSurname((String) entity.getProperty("surname"));
		member.setNicknames((String) entity.getProperty("nicknames"));
		member.setDescription((String) entity.getProperty("description"));
		member.setProfilePictureUrl((String) entity
				.getProperty("profilePictureUrl"));
		member.setKey(KeyFactory.keyToString(entity.getKey()));
		System.out.println("Just got " + member);
		return member;
	}

	public void delete(String key) {
		Transaction txn = datastoreService.beginTransaction();
		try {
			datastoreService.delete(KeyFactory.stringToKey(key));
			txn.commit();
		} finally {
			if (txn.isActive()) {
				txn.rollback();
			}
		}
	}

	public Member get(String key) {
		try {
			Entity result = datastoreService.get(KeyFactory.stringToKey(key));
			return createMember(result);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
