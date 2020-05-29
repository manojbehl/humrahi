package com.ibm.humrahi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.humrahi.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

	public User findByUserName(String userName);

	public Iterable<User> findByRoleIgnoreCase(String role);

}
