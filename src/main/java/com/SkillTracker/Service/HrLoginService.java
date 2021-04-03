package com.SkillTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SkillTracker.Bean.HRManagers;
import com.SkillTracker.Bean.LoginResultClass;
import com.SkillTracker.dao.HRLoginRepository;

//Service Class for adding new HR
@Service
public class HrLoginService implements HrLoginServiceInterface {
	@Autowired
	HRLoginRepository repo;
	HRManagers existingHrLogin = new HRManagers(); //variable to get information about HR from database
	LoginResultClass loginResult = new LoginResultClass(); //Object to return JSON Object to Angular
	HRManagers logedinHr = new HRManagers();
	LoginResultClass UpdateHR = new LoginResultClass();
//	Function to Check Login Status
	
	public LoginResultClass loginHrManager(HRManagers hrmanager) {
		existingHrLogin = repo.findByHrUserName(hrmanager.getHrUserName()); //gets the value from databse with the username
//		System.out.println("Existing HR: "+existingHrLogin);
		//Checks id HR details exists in database or not
		if(existingHrLogin != null) {  
			//condition to check entered username & password are matching with database also checks for user is active or not
			if(existingHrLogin.getHrUserName().equals(hrmanager.getHrUserName()) &&
					existingHrLogin.getHrPassword().equals(hrmanager.getHrPassword()) &&
					existingHrLogin.getAccessStatus().equals("Active")) {
				loginResult.setLoginResult("Login Successful....");  //If username password matched with databse and use is active
			}
			//Checks if User is InActive
			else if(existingHrLogin.getAccessStatus().equals("InActive")){
				loginResult.setLoginResult("Your Account is not Active"); //If user is InActive
			}else{
				loginResult.setLoginResult("Incorrect Username or password"); //If user enters incorrect username and password
			}
		}
		else {  
			loginResult.setLoginResult("Username does not exists"); //If Username does not exists in database
		} 	
		return	loginResult;
		}

		public HRManagers getActiveHRDetails() {
			logedinHr = repo.findByAccessStatus("Active");
			return logedinHr;
		}

		public List<HRManagers> viewAllHRManagers(){
			return (List<HRManagers>) repo.findAll();
		}

		public LoginResultClass updatePassword(HRManagers hrmanager) {
			existingHrLogin = repo.findByHrUserName(hrmanager.getHrUserName()); 
			if(existingHrLogin == null) {
				loginResult.setUpdateHRResult("Username does not exist"); 
			}else {
				repo.save(hrmanager);
				loginResult.setUpdateHRResult("HR Details updated successfully");
			}
			return	loginResult;
		}

		public LoginResultClass deleteHRManager(HRManagers hrmanager) {
			existingHrLogin = repo.findByHrUserName(hrmanager.getHrUserName()); 
			if(existingHrLogin == null) {
				loginResult.setUpdateHRResult("Username does not exist"); 
			}else {
				repo.delete(hrmanager);
				loginResult.setUpdateHRResult("HR Details deleted successfully");
			}
			return	loginResult;
		}

		public HRManagers getHrManagerByUserName(String hrUserName) {
			return repo.findByHrUserName(hrUserName);
		}
	}
