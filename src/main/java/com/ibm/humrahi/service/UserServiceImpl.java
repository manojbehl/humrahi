package com.ibm.humrahi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.humrahi.dto.UserDto;
import com.ibm.humrahi.entity.User;
import com.ibm.humrahi.repository.UserRepo;
import com.ibm.humrahi.transformer.DomaintoDtoTransformer;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepo userRepository;
	
	@Autowired
	DomaintoDtoTransformer domaintoDtoTransformer;
	
	public Iterable<UserDto> getAllUsers() {
		Iterable<User> iterable= this.userRepository.findAll();

		List<User> userList = new ArrayList<User>();
		iterable.forEach(e -> userList.add(e));

		
		return domaintoDtoTransformer.convertDomainToDto(userList);
	}

	public User create(User user) {
		
		return this.userRepository.save(user);
	}

	public void update(User user) {
		this.userRepository.save(user);
	}
}
