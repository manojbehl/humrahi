package com.ibm.humrahi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.humrahi.dto.HelpTypeDto;
import com.ibm.humrahi.service.HelpServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class HelpController {

	@Autowired
	HelpServiceImpl helpServiceImpl;
	
	@GetMapping(path="/api/helpType")
	public ResponseEntity  returnHelpList() {
		
		List<HelpTypeDto> listOfHelpType = helpServiceImpl.retrunHelpList();
		
		return ResponseEntity.ok(listOfHelpType);
	}

}
