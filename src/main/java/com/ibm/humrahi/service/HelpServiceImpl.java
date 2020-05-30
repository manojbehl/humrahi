package com.ibm.humrahi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.humrahi.entity.HelpType;
import com.ibm.humrahi.repository.HelpRepo;

@Service
public class HelpServiceImpl {
	
	@Autowired
	HelpRepo helpRepo;

	public void createHelp(HelpType help) {
		helpRepo.save(help);
	}

}
