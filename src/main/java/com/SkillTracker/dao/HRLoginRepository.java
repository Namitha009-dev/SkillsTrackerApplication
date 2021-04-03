package com.SkillTracker.dao;

import org.springframework.data.repository.CrudRepository;

import com.SkillTracker.Bean.HRManagers;

public interface HRLoginRepository extends CrudRepository<HRManagers, Integer> {

	HRManagers findByHrUserName(String hrUserName);

	HRManagers findByAccessStatus(String string);

	void deleteByHrUserName(String hrUserName);
	
}
