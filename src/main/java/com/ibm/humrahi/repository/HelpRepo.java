package com.ibm.humrahi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.humrahi.entity.HelpType;

@Repository
public interface HelpRepo extends JpaRepository<HelpType, Long>{

	public HelpType findByHelp(String help);
}
