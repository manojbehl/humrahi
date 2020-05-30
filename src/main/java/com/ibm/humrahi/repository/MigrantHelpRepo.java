package com.ibm.humrahi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.humrahi.entity.Migrant;

@Repository
public interface MigrantHelpRepo extends CrudRepository<Migrant, Long>{

	public Iterable<Migrant> findByCurrentCityIgnoreCase(String city);
	
}
