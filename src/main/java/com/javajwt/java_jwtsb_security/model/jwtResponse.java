package com.javajwt.java_jwtsb_security.model;

public class jwtResponse {

	String token;

	public jwtResponse() {
	}

	public jwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}
