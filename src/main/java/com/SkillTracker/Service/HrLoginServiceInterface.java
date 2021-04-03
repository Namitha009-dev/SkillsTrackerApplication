package com.SkillTracker.Service;

import java.util.List;

import com.SkillTracker.Bean.HRManagers;
import com.SkillTracker.Bean.LoginResultClass;

public interface HrLoginServiceInterface {
	public LoginResultClass loginHrManager(HRManagers hrmanager);
	public HRManagers getActiveHRDetails();
	public List<HRManagers> viewAllHRManagers();
}
