package com.ibm.humrahi.transformer;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ibm.humrahi.dto.UserDto;
import com.ibm.humrahi.entity.User;

@Component
public class DtoToDomainTransformer {


	public User convertDtoToDomain(UserDto userDto){
		User  user = new User();
			
		BeanUtils.copyProperties(userDto, user);
			
		
		return user;
	}

}
