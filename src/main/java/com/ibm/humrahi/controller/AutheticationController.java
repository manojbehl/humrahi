package com.ibm.humrahi.controller;

import java.util.ArrayList;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.humrahi.dto.AuthUser;
import com.ibm.humrahi.dto.UserDto;
import com.ibm.humrahi.errorhanding.BusinessException;
import com.ibm.humrahi.errorhanding.TechnicalException;
import com.ibm.humrahi.repository.UserRepo;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/login")
public class AutheticationController{
	
	@Autowired
	UserRepo userRepo;

	
	@GetMapping
	public ResponseEntity login() throws BusinessException, TechnicalException {
		
		Object prinicpal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDto  userDetail = new UserDto();
		if(prinicpal instanceof UserDetails) {
			AuthUser authUser = (AuthUser)prinicpal;
			userDetail.setId(authUser.getId());
			userDetail.setUserName(authUser.getUsername());
			userDetail.setFirstName(authUser.getFirstName());
			userDetail.setLastName(authUser.getLastName());
			userDetail.setRole(authUser.getAuthorities().iterator().next().getAuthority());
			//userDetail.setDisplayName(authUser.getDisplayName());
			
			/*
			 * for (Iterator iterator = authUser.getAuthorities().iterator();
			 * iterator.hasNext();) { GrantedAuthority type = (GrantedAuthority)
			 * iterator.next(); userDetail.setRole(type.getAuthority()); }
			 */
			String accessToken = generateAuthToken(userDetail);
			userDetail.setAccessToken(accessToken);
			
		}
		
		 return ResponseEntity.ok(userDetail);
	}
	
	private String generateAuthToken(UserDto userDto) {
		String authToken = userDto.getUserName()+ "-" + userDto.getFirstName() + "-" + userDto.getId();

		return Base64.getEncoder().encodeToString(authToken.getBytes());
	}

	
	

}
