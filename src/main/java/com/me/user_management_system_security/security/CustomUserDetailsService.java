package com.me.user_management_system_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.me.user_management_system_security.exception.UserNameNotFoundException;
import com.me.user_management_system_security.exception.UserNotFoundByIdException;
import com.me.user_management_system_security.repository.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UserNameNotFoundException {
		return userRepo.findByUserName(username).map(user -> new CustomUserDetails(user)).orElseThrow(
				()->new UserNameNotFoundException ("Failed to authenticate the user."));
	}
}