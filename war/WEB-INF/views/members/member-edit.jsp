<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Member</title>
</head>
<body>
	<form:form commandName="member" action="/members/${member.key}">
		<form:label path="firstName">
			<spring:message code="firstName" text="First Name" />
		</form:label>
		<form:input path="firstName" />
		<br>
		<form:label path="surname">
			<spring:message code="surname" text="Surname" />
		</form:label>
		<form:input path="surname" />
		<br>
		<form:label path="nicknames">
			<spring:message code="nicknames" text="Nicknames" />
		</form:label>
		<form:input path="nicknames" />
		<br>
		<form:label path="description">
			<spring:message code="description" text="Description" />
		</form:label>
		<form:input path="description" />
		<br>
		<form:label path="profilePictureUrl">
			<spring:message code="profilePictureUrl" text="Profile Picture Url" />
		</form:label>
		<form:input path="profilePictureUrl" />
		<br>
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>