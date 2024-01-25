package com.me.user_management_system_security.utility;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ResponseStructure<T>
{
	private int status;
	private String message;
	private T data;
}

