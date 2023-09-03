package com.Amadeus.CaseStudy.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Flight extends BaseEntity {

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departureAirport")
	private Airport departureAirport;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destinationAirport")
	private Airport destinationAirport;

	private LocalDateTime departureDate;
	
	private LocalDateTime returnDate;
	
	private Float price;

	public Flight()
	{
	}
	
	public Flight(Long id, Airport departureAirport,Airport destinationAirport,LocalDateTime departureDate,LocalDateTime returnDate,Float price){
        super();
        this.id = id;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.price = price;
    }
	
	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}
}
