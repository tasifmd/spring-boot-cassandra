package com.tasif.springcassandra.user.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("vehicle")
public class Vehicle {
	
	@PrimaryKey
	private String vehicleId;
	
	private String vehicleName;
	
	private String vehicleModel;
	
	private String vehicleNumber;

}
