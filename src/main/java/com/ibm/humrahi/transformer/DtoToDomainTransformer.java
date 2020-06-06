package com.ibm.humrahi.transformer;

import java.util.Iterator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.humrahi.dto.HelpTypeDto;
import com.ibm.humrahi.dto.UserDto;
import com.ibm.humrahi.entity.HelpType;
import com.ibm.humrahi.entity.MigrantHelp;
import com.ibm.humrahi.entity.User;
import com.ibm.humrahi.entity.UserHelp;
import com.ibm.humrahi.repository.HelpRepo;

@Component
public class DtoToDomainTransformer {

	@Autowired
	HelpRepo helpRepo;
	
	public User convertDtoToDomain(UserDto userDto){
		User  user = new User();
			
		BeanUtils.copyProperties(userDto, user, "helpProvided");
			
		UserHelp userHelp = null;
		
		for (Iterator iterator = userDto.getHelpProvided().iterator(); iterator.hasNext();) {

			HelpTypeDto type = (HelpTypeDto) iterator.next();

			System.err.println("type.getHelp()" + type.getHelp());

			userHelp = new UserHelp();

			//HelpType help = helpRepo.findByHelp(type.getHelp());

			userHelp.setHelpId(type.getId());
			userHelp.setUser(user);

			user.getHelpProvided().add(userHelp);

		}

		
		return user;
	}

}
