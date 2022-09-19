package com.reto.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
	private String token;

	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	public JwtResponse() {
	}
	
	
	
}
