package com.ibm.humrahi.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.humrahi.dto.HelpTypeDto;
import com.ibm.humrahi.dto.MigrantDto;
import com.ibm.humrahi.entity.HelpType;
import com.ibm.humrahi.entity.Migrant;
import com.ibm.humrahi.entity.MigrantHelp;
import com.ibm.humrahi.repository.HelpRepo;
import com.ibm.humrahi.repository.MigrantHelpRepo;

@Service
public class MigrantServiceImpl {

	@Autowired
	MigrantHelpRepo migrantHelpRepo;

	@Autowired
	HelpRepo helpRepo;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

	public MigrantDto createMigrantHelpRequest(MigrantDto migrantDto) {

		Migrant migrant = new Migrant();

		BeanUtils.copyProperties(migrantDto, migrant, new String[] { "dateTime", "helpProvided" });

		if (migrantDto.getDateTime() != null) {
			try {
				migrant.setDateTime(new Timestamp(simpleDateFormat.parse(migrantDto.getDateTime()).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		List<HelpType> listOfHelp = new ArrayList<HelpType>();

		MigrantHelp migrantHelp = null;

		for (Iterator iterator = migrantDto.getHelpProvided().iterator(); iterator.hasNext();) {

			HelpTypeDto type = (HelpTypeDto) iterator.next();

			System.err.println("type.getHelp()" + type.getHelp());

			migrantHelp = new MigrantHelp();

			HelpType help = helpRepo.findByHelp(type.getHelp());

			migrantHelp.setHelpId(help.getId());
			migrantHelp.setMigrant(migrant);

			migrant.getHelpProvided().add(migrantHelp);

		}

		System.err.println("migrant.getHelpProvided().size()" + migrant.getHelpProvided().size());

		Migrant savedMigrant = migrantHelpRepo.save(migrant);

		MigrantDto newMigrantDto = new MigrantDto();

		BeanUtils.copyProperties(savedMigrant, newMigrantDto, "dateTime", "helpProvided");

		if (savedMigrant.getDateTime() != null) {
			newMigrantDto.setDateTime(simpleDateFormat.format(savedMigrant.getDateTime()));
		}
		HelpTypeDto helpDto = null;

		/*
		 * if (savedMigrant.getHelpProvided() != null) { for (Iterator iterator =
		 * savedMigrant.getHelpProvided().iterator(); iterator.hasNext();) { MigrantHelp
		 * migrantHelp1 = (MigrantHelp) iterator.next(); Optional<HelpType> optionalHelp
		 * = helpRepo.findById(migrantHelp1.getHelpId());
		 * 
		 * if (optionalHelp.isPresent()) { helpDto = new HelpTypeDto();
		 * helpDto.setHelp(optionalHelp.get().getHelp());
		 * helpDto.setId(optionalHelp.get().getId());
		 * 
		 * newMigrantDto.getHelpProvided().add(helpDto);
		 * 
		 * }
		 * 
		 * } }
		 */
		return newMigrantDto;
	}

	public List<MigrantDto> returnMigrantHelp(String city) {
		Iterable<Migrant> iterable = migrantHelpRepo.findByCurrentCityIgnoreCase(city);

		List<Migrant> migrantList = new ArrayList<Migrant>();
		iterable.forEach(e -> migrantList.add(e));

		List<MigrantDto> listMigrantDtos = new ArrayList<MigrantDto>();
		MigrantDto migrantDto = null;
		for (Iterator iterator = migrantList.iterator(); iterator.hasNext();) {
			Migrant migrant = (Migrant) iterator.next();
			migrantDto = new MigrantDto();
			BeanUtils.copyProperties(migrant, migrantDto, "dateTime", "helpProvided");

			if (migrant.getDateTime() != null) {
				migrantDto.setDateTime(simpleDateFormat.format(migrant.getDateTime()));
			}

			System.err.println("migrant.getHelpProvided() "+  migrant.getHelpProvided() );
			
			if (migrant.getHelpProvided() != null) {
				for (Iterator iteratorForHelp = migrant.getHelpProvided().iterator(); iteratorForHelp.hasNext();) {
					MigrantHelp migrantHelp = (MigrantHelp) iteratorForHelp.next();
					System.err.println("migrantHelp.getHelpId()"+ migrantHelp.getHelpId());
					Optional<HelpType> optionalHelp = helpRepo.findById(migrantHelp.getHelpId());

					if (optionalHelp.isPresent()) {
						HelpTypeDto helpDto = new HelpTypeDto();
						helpDto.setHelp(optionalHelp.get().getHelp());
						helpDto.setId(optionalHelp.get().getId());
						helpDto.setDescription(optionalHelp.get().getDescription());

						migrantDto.getHelpProvided().add(helpDto);

					}

				}
			}

			listMigrantDtos.add(migrantDto);
		}

		return listMigrantDtos;

	}

}
