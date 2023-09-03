package com.Amadeus.CaseStudy.model;


import javax.persistence.Entity;

@Entity
public class Airport extends BaseEntity {


    private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public Airport(Long id, String city){
        super();
        this.id = id;
        this.city = city;
    }
	public Airport()
	{
		
	}
	
}
