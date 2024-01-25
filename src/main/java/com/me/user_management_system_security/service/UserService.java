package com.me.user_management_system_security.service;

import org.springframework.http.ResponseEntity;

import com.me.user_management_system_security.entity.User;
import com.me.user_management_system_security.request.UserRequest;
import com.me.user_management_system_security.response.UserResponse;
import com.me.user_management_system_security.utility.ResponseStructure;


public interface UserService 
{
	// 1. Adding the User
	
	ResponseEntity<ResponseStructure<UserResponse>> addUser(UserRequest userRequest);
	
	// 2. Updating the User

	ResponseEntity<ResponseStructure<UserResponse>> updateUserById(int userId, User user);
	
	// 3. Deleting the User
	
	ResponseEntity<ResponseStructure<UserResponse>> deleteUserById(int userId);
	
	// 4. Finding the User

	ResponseEntity<ResponseStructure<UserResponse>> findUserById(int userId);
}
