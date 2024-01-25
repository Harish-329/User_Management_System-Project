package com.me.user_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.user_management_system.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> 
{
	
}