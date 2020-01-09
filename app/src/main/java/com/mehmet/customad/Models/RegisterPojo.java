package com.mehmet.customad.Models;

public class RegisterPojo {
	private boolean result;
	private Object token;

	public void setResult(boolean result){
		this.result = result;
	}

	public boolean isResult(){
		return result;
	}

	public void setToken(Object token){
		this.token = token;
	}

	public Object getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"RegisterPojo{" + 
			"result = '" + result + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}
