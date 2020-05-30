package com.ibm.humrahi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.humrahi.dto.MigrantDto;
import com.ibm.humrahi.service.MigrantServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class MigrantContoller {

	@Autowired
	MigrantServiceImpl migrantServiceImpl;
	
	@PostMapping(path = "/api/migrant/{userId}")
	public ResponseEntity createMigrantHelpRequest(@RequestBody MigrantDto migrantDto,
			@PathVariable(name = "userId") long userId) {

		migrantDto.setUserId(userId);
		MigrantDto saved = migrantServiceImpl.createMigrantHelpRequest(migrantDto);
		
		return ResponseEntity.ok(saved);
	}

	@GetMapping(path = "/api/migrant/{city}")
	public ResponseEntity returnMigrantHelpRequest(@PathVariable(name="city") String city) {

		
		List<MigrantDto> saved = migrantServiceImpl.returnMigrantHelp(city);
		
		return ResponseEntity.ok(saved);
	}


}
