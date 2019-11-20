package com.tasif.springcassandra.user.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table("user")
@Data
public class User {
	
	@PrimaryKey
	private int userId;
	
	private String userName;
	
	private String userEmail;
	
	private String userMobileNumber;

}
