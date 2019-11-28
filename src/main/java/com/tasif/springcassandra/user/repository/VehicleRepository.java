package com.tasif.springcassandra.user.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.tasif.springcassandra.user.model.Vehicle;

@Repository
public interface VehicleRepository extends CassandraRepository<Vehicle, String> {

}
