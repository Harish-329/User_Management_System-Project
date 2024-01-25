package com.me.user_management_system_security.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserNameNotFoundException extends RuntimeException{

	private String message;
	
}
