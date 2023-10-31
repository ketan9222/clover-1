package com.demo.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
