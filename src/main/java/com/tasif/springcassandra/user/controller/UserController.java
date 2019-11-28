package com.tasif.springcassandra.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.springcassandra.user.dto.UserDto;
import com.tasif.springcassandra.user.model.User;
import com.tasif.springcassandra.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public String create(@RequestBody UserDto user) {
		String response = userService.createUser(user);
		return response;
	}

	@GetMapping
	public List<User> getAllUser() {
		List<User> users = userService.getAllUser();
		return users;
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable String userId) {
		User user = userService.getUser(userId);
		return user;
	}

	@PutMapping("/{userId}")
	public String update(@PathVariable String userId,@RequestBody UserDto user) {
		String response = userService.updateUser(userId,user);
		return response;
	}
	
	@DeleteMapping("/{userId}")
	public String delete(@PathVariable String userId) {
		String response = userService.deleteUser(userId);
		return response;
	}
}
