package com.orakoglu.iim.r.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orakoglu.iim.r.entity.User;
import com.orakoglu.iim.r.repository.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class CheckUser {

	@Autowired
	UserRepository userRepository;

	@GetMapping(path = "/", produces = "application/json")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

}
