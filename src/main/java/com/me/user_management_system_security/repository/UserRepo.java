package com.me.user_management_system_security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.user_management_system_security.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> 
{

	Optional<User> findByUserName(String username);	
}