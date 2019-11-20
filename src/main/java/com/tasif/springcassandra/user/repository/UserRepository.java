package com.tasif.springcassandra.user.repository;

import org.springframework.data.cassandra.core.mapping.CassandraPersistentEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.tasif.springcassandra.user.model.User;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer>, CassandraPersistentEntity<User> {

}
