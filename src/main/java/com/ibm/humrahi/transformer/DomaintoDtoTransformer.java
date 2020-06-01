package com.ibm.humrahi.transformer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
public class DomaintoDtoTransformer {

	@Autowired
	HelpRepo helpRepo;

	
	public List<UserDto> convertDomainToDto(List<User> listOfUsers){
		 List<UserDto> listOfIUserDtos = new ArrayList<UserDto>();
		UserDto  userDto = null;
		for (Iterator iterator = listOfUsers.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			userDto = new UserDto();
			
			BeanUtils.copyProperties(user, userDto, "helpProvided");
			
			
			
			listOfIUserDtos.add(userDto);
		}
		
		return listOfIUserDtos;
	}
	
	public UserDto convertDomainToDto(User user){
		UserDto  userDto = new UserDto();
			
		BeanUtils.copyProperties(user, userDto, "helpProvided");
		
		if (user.getHelpProvided() != null) {
			for (Iterator iteratorForHelp = user.getHelpProvided().iterator(); iteratorForHelp.hasNext();) {
				UserHelp migrantHelp = (UserHelp) iteratorForHelp.next();
				System.err.println("migrantHelp.getHelpId()"+ migrantHelp.getHelpId());
				Optional<HelpType> optionalHelp = helpRepo.findById(migrantHelp.getHelpId());

				if (optionalHelp.isPresent()) {
					HelpTypeDto helpDto = new HelpTypeDto();
					helpDto.setHelp(optionalHelp.get().getHelp());
					helpDto.setId(optionalHelp.get().getId());
					helpDto.setDescription(optionalHelp.get().getDescription());

					userDto.getHelpProvided().add(helpDto);

				}

			}
		}

			
		
		return userDto;
	}

}
