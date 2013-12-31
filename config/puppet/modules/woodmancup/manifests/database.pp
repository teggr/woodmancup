class woodmancup::database {

  class { 'postgresql::server':
    ip_mask_allow_all_users    => '0.0.0.0/0',
    listen_addresses           => '*',
  }

  postgresql::server::db { 'woodmancup':
    user     => 'woodmancup',
    password => postgresql_password('woodmancup', 'woodmancup'), 
  }

  firewall { '100 allow postgres access':
    port   => [5432],
    proto  => tcp,
    action => accept,
  }

}