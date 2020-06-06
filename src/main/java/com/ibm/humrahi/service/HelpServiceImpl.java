package com.ibm.humrahi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.humrahi.dto.HelpTypeDto;
import com.ibm.humrahi.entity.HelpType;
import com.ibm.humrahi.repository.HelpRepo;

@Service
public class HelpServiceImpl {

	@Autowired
	HelpRepo helpRepo;

	public void createHelp(HelpType help) {
		helpRepo.save(help);
	}

	public List<HelpTypeDto> retrunHelpList() {
	
	 List<HelpType> listOfHelpType	= helpRepo.findAll();
	 
	 List<HelpTypeDto> helpTypeDtos = new ArrayList<HelpTypeDto>();
	 HelpTypeDto helpTypeDto = null;
	 for (Iterator iterator = listOfHelpType.iterator(); iterator.hasNext();) {
		HelpType helpType = (HelpType) iterator.next();
		helpTypeDto = new HelpTypeDto();
		
		BeanUtils.copyProperties(helpType, helpTypeDto);
		helpTypeDtos.add(helpTypeDto);
	 }
	 
	 return helpTypeDtos;
		
	}

}
