package com.tasif.springcassandra.user.model;

import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table("user")
@Data
public class User {
	
	@PrimaryKey
	private String userId;
	
	private String userName;
	
	private String userEmail;
	
	private String userMobileNumber;
	
	//@Transient private List<Vehicle> vehicles;

}
