package com.mehmet.customad.Models;

public class LoginPojo {

	private Object user_name;
	private Object id;
	private Object email;
	private Object token;
	private boolean success;


	public void setUser_name(Object user_name){
		this.user_name = user_name;
	}

	public Object getUser_name(){
		return user_name;
	}

	public void setId(Object id){
		this.id = id;
	}

	public Object getId(){
		return id;
	}

	public void setEmail(Object email){
		this.email = email;
	}

	public Object getEmail(){
		return email;
	}

	public void setToken(Object token){
		this.token = token;
	}

	public Object getToken(){
		return token;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
 	public String toString(){
		return 
			"LoginPojo{" + 
			"user_name = '" + user_name + '\'' +
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",token = '" + token + '\'' + 
			",success = '" + success + '\'' +
			"}";
		}
}
