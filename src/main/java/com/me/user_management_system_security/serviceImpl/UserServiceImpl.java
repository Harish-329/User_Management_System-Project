package com.me.user_management_system_security.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.me.user_management_system_security.entity.User;
import com.me.user_management_system_security.exception.UserNotFoundByIdException;
import com.me.user_management_system_security.repository.UserRepo;
import com.me.user_management_system_security.request.UserRequest;
import com.me.user_management_system_security.response.UserResponse;
import com.me.user_management_system_security.service.UserService;
import com.me.user_management_system_security.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private ResponseStructure<UserResponse> responseStructure;
	
	private User mapToUser(UserRequest userRequest)
	{
		 return User.builder()
		.userName(userRequest.getUserName())
		.userEmailId(userRequest.getUserEmailId())
		.userPassword(encoder.encode(userRequest.getUserPassword()))
		.build();
	}
	
	private UserResponse mapToUserResponse(User user)
	{
		return UserResponse.builder()
		.userId(user.getUserId())
		.userName(user.getUserName())
		.userEmailId(user.getUserEmailId())
		.build();
	}
	
	// 1. Adding the User
	
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> addUser(UserRequest userRequest) 
	{
		User user1 = userRepo.save(mapToUser(userRequest));
		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("User Saved Successfully");
		responseStructure.setData(mapToUserResponse(user1));
	
		return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure, HttpStatus.CREATED);
	}
	
	// 2. Updating the User ~ Alternative Method

//	@Override
//	public ResponseEntity<ResponseStructure<User>> updateUser(int userId, User user) 
//	{
//		User user = userrepo.findById(userId).orElseThrow(() -> new RuntimeException());
//		
//		user.setUserId(userId);
//		user = userrepo.save(user);
//		
//		ResponseStructure<User> resstr = new ResponseStructure<User>();
	
//		resstr.setStatus(HttpStatus.OK.value());
//		resstr.setMessage("User Updated Successfully Done");
//		resstr.setData(user);
//	
//		return new ResponseEntity<ResponseStructure<User>>(resstr, HttpStatus.OK);
//	}
	
	// 2. Updating the User
	
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(int userId, User user)
	{
		User user2 = userRepo.findById(userId)
				.map(u -> {
						   user.setUserId(userId);
						   return userRepo.save(user);
				})
				.orElseThrow(() -> new RuntimeException());
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("User Updated Successfully");
		responseStructure.setData(mapToUserResponse(user2));
	
		return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure, HttpStatus.OK);
	}
	
	// 3. Finding the User
	
		@Override
		public ResponseEntity<ResponseStructure<UserResponse>> findUserById(int userId) 
		{
			User user3=userRepo.findById(userId).orElseThrow(()->new UserNotFoundByIdException("Failed to find the user"));
			
				responseStructure.setStatus(HttpStatus.FOUND.value());
				responseStructure.setMessage("*** User Found ***" );
				responseStructure.setData(mapToUserResponse(user3));
				
				return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.FOUND);
		}
	
	// 4. Deleting the User
	
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> deleteUserById(int userId) 
	{
		
		User user4=userRepo.findById(userId).orElseThrow(()->new RuntimeException());
		userRepo.delete(user4);
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("***** User Successfully Deleted *****");
		responseStructure.setData(mapToUserResponse(user4));
		
		return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.OK);
	}
}
