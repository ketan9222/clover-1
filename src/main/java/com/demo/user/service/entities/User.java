package com.demo.user.service.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

	@Id
	private String userId;
	
	private String name;

	private String  email;
	
	private String about;
	
	
	//this transient ensures this info is not saved in database
	@Transient
	private List<Rating> ratings = new ArrayList<>();

}
