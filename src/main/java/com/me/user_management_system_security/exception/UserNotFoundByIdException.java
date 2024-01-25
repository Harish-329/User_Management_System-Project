package com.me.user_management_system_security.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserNotFoundByIdException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4578845684482249002L;
	private String message;
}
