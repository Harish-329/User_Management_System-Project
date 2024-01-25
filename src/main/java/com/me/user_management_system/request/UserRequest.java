package com.me.user_management_system.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest 
{
	private String userName;
	
	@NotNull(message = "userEmailId cannot be null")
	@Email(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", message = " invalid email ")
	private String userEmailId;
	
	@Size(min = 8, max = 24, message = "Password must be between 8 and upto 24 characters")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must contain at least "
			+ "one uppercase letter"
			+ "one lowercase letter"
			+ "one number"
			+ "and"
			+ "one special character")
	private String userPassword;
}