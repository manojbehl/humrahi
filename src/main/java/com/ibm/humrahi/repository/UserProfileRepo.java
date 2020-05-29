package com.ibm.humrahi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.humrahi.entity.UserProfile;

@Repository
public interface UserProfileRepo extends CrudRepository<UserProfile, Long>{

	public UserProfile findByUserIdAndGroupIdAndGroupMemberId(long userId, long groupId, long groupMemberId);
}
