package com.SkillTracker.Bean;

//This bean is for sharing response to Angular in the format of JSON Object
public class LoginResultClass {
	String loginResult; //Result of rest API will be stored in this parameter which will be shared with Angular
	String updateHRResult;
	public LoginResultClass() {
		
	}
	
	public LoginResultClass(String loginResult, String updateHRResult) {
		this.loginResult = loginResult;
		this.updateHRResult = updateHRResult;
	}

	public String getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}

	public String getUpdateHRResult() {
		return updateHRResult;
	}

	public void setUpdateHRResult(String updateHRResult) {
		this.updateHRResult = updateHRResult;
	}

	@Override
	public String toString() {
		return "LoginResultClass [loginResult=" + loginResult + ", updateHRResult=" + updateHRResult + "]";
	}
	
	
}