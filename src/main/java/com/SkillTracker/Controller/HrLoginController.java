package com.SkillTracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SkillTracker.Bean.HRManagers;
import com.SkillTracker.Bean.LoginResultClass;
import com.SkillTracker.Service.HrLoginService;

//This is controller Class for Login for HR Manager
	@RestController
	@RequestMapping("/hrManager")
	public class HrLoginController {
		@Autowired
		HrLoginService theService;
		//This is POST Request for Login for HR Manager	
			//URL to hit: http://localhost:9095/hrManager/Login
//		JSON Body:{
//			"hrUserName":"Chitra.S",
//			"hrPassword":"Chitra@789"
//		}
		@PostMapping("/Login")
		public LoginResultClass addnewHrManager(@RequestBody HRManagers hrmanager) {
			return theService.loginHrManager(hrmanager);
		}
		
		@GetMapping("/getHrManagerByUserName/{hrUserName}")
		HRManagers getHrManagerByUserName(@PathVariable String hrUserName) {
			return theService.getHrManagerByUserName(hrUserName);
		}
		
		@GetMapping("/getActiveHRDetails")
		public HRManagers getActiveHRDetails() {
			return theService.getActiveHRDetails();
		}
		
		@GetMapping("/viewAllHRManagers")
		List<HRManagers> viewAllHRManagers(){
			return theService.viewAllHRManagers();
		}
		
		@PostMapping("/updatePassword")
		public LoginResultClass updatePassword(@RequestBody HRManagers hrmanager) {
			return theService.updatePassword(hrmanager);
		}
		
		@PostMapping("/deleteHRManager")
		public LoginResultClass deleteHRManager(@RequestBody HRManagers hrmanager) {
			return theService.deleteHRManager(hrmanager);
		}
	}

