package com.ibm.humrahi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.humrahi.dto.UserDto;
import com.ibm.humrahi.entity.User;
import com.ibm.humrahi.repository.UserRepo;
import com.ibm.humrahi.transformer.DomaintoDtoTransformer;
import com.ibm.humrahi.transformer.DtoToDomainTransformer;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepo userRepository;
	
	@Autowired
	DomaintoDtoTransformer domaintoDtoTransformer;
	
	@Autowired
	DtoToDomainTransformer dtoToDomainTransformer;
	
	public Iterable<UserDto> getAllUsers() {
		Iterable<User> iterable= this.userRepository.findAll();

		List<User> userList = new ArrayList<User>();
		iterable.forEach(e -> userList.add(e));

		
		return domaintoDtoTransformer.convertDomainToDto(userList);
	}

	public Iterable<UserDto> getAllUsers(String role) {
		Iterable<User> iterable= this.userRepository.findByRoleIgnoreCase(role)

		List<User> userList = new ArrayList<User>();
		iterable.forEach(e -> userList.add(e));

		
		return domaintoDtoTransformer.convertDomainToDto(userList);
	}

	
	public UserDto findById(long id) {
		
		Optional<User> optionalUser  = this.userRepository.findById(id);
		if(optionalUser.isPresent()) {
			User user= optionalUser.get();
			
			return domaintoDtoTransformer.convertDomainToDto(user);
		}
		return null; 
	}

	public boolean create(UserDto userDto) {
		
		User user = dtoToDomainTransformer.convertDtoToDomain(userDto);
		
		User entity =  this.userRepository.save(user);
		
		if (entity != null)
			return true;
		
		
		return false;
	}

	
	public User create(User user) {
		
		return this.userRepository.save(user);
	}

	public void update(User user) {
		this.userRepository.save(user);
	}
}
