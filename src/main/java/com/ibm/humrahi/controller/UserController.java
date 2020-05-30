package com.ibm.humrahi.controller;

import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.humrahi.dto.UserDto;
import com.ibm.humrahi.entity.User;
import com.ibm.humrahi.errorhanding.BusinessException;
import com.ibm.humrahi.errorhanding.TechnicalException;
import com.ibm.humrahi.service.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@PostMapping(path="/api/signup")
	public ResponseEntity login(@RequestBody UserDto userDto) throws BusinessException, TechnicalException {
		boolean booleanValue =  userService.create(userDto);
		
		return ResponseEntity.ok(booleanValue);

	}

	@GetMapping(path="/api/user/{role}")
	public ResponseEntity login(@PathVariable(name="role") String role) throws BusinessException, TechnicalException {
		Iterable<UserDto> userDtoList =  userService.getAllUsers(role);
		
		return ResponseEntity.ok(userDtoList);

	}

	@GetMapping(path="/api/user")
	public ResponseEntity login() throws BusinessException, TechnicalException {
		Iterable<UserDto> userDtoList =  userService.getAllUsers();
		
		return ResponseEntity.ok(userDtoList);

	}

}
