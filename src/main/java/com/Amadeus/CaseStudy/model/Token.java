package com.Amadeus.CaseStudy.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Token extends BaseEntity{

	private String token; 
	private LocalDateTime expireDate;
	public LocalDateTime getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDateTime expireDate) {
		this.expireDate = expireDate;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
