package com.demo.user.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.user.service.entities.Rating;
import com.demo.user.service.entities.User;
import com.demo.user.service.exceptions.ResourceNotFoundException;
import com.demo.user.service.repositories.UserRepository;
import com.demo.user.service.services.UserService;

import ch.qos.logback.classic.Logger;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	

	@Override
	public User saveUser(User user) {
	
		//unique id generator
		String randomUserId = UUID.randomUUID().toString(); 
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		 
		User user=  userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !!! :"+userId));
		
		ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8085/ratings/users/"+user.getUserId(), ArrayList.class);
		
		user.setRatings(ratingsOfUser);
		return user;
	}

}
