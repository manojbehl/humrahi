package com.ibm.humrahi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ibm.humrahi.dto.AuthUser;
import com.ibm.humrahi.entity.User;
import com.ibm.humrahi.repository.UserRepo;

public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;

	@Override
	public org.springframework.security.core.userdetails.User loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		System.err.println(userName);

		User user = userRepo.findByUserName(userName);

		if (user == null)
			throw new UsernameNotFoundException("Unauthorised Access");
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());

		grantedAuthorityList.add(simpleGrantedAuthority);
		
		return new AuthUser(user.getId(), user.getUserName(), user.getPassword(), user.getFirstName(),user.getLastName(),
				grantedAuthorityList);

		/*
		 * PromotorLogin promotorLogin=
		 * promotorLoginRepoistory.findByUserNameAndStatus(userName, 1);
		 * if(promotorLogin==null) throw new
		 * UsernameNotFoundException("Unauthorised Access");
		 * 
		 * if(promotorLogin.getStatus()!=1) throw new
		 * UsernameNotFoundException("Unauthorised Access");
		 * 
		 * System.err.println(promotorLogin.getPassword()); return new
		 * UserDetails(promotorLogin, new ArrayList<>());
		 */

		
	}

}
