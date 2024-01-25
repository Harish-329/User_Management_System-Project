package com.me.user_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.me.user_management_system.entity.User;
import com.me.user_management_system.request.UserRequest;
import com.me.user_management_system.response.UserResponse;
import com.me.user_management_system.service.UserService;
import com.me.user_management_system.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController 
{
	@Autowired
	private UserService userService;
	
	// 1. Adding the User
	
	@PostMapping(path = "/add")
	public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody @Valid UserRequest userRequest)
	{
		return userService.addUser(userRequest);
	}
	
	// 2. Updating the User
	
	@PutMapping(value = "/update/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(@PathVariable int userId , @RequestBody User user)
	{
		return userService.updateUserById(userId , user);
	}
	
	// 3. Deleting the User
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> deleteUserById(@PathVariable int userId)
	{
		return userService.deleteUserById(userId);
	}
	
	// 4. Finding the User
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable int userId)
	{
		return userService.findUserById(userId);
	}
}