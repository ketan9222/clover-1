package com.demo.user.service.services;

import com.demo.user.service.entities.User;

import java.util.List;

public interface UserService {
	
	//all operations to be written here

	//create user
	User saveUser(User user);
	
	//get user
	List<User> getAllUser();
	
	//get user of specific Id
	User getUser(String userId);
	
	//can add update n del here
	
}
