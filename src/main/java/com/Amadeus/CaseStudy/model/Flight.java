package com.Amadeus.CaseStudy.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Flight Search API Documentation", description = "Model")
public class Flight extends BaseEntity {

	@ApiModelProperty(value = "Name Of Departure City")
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departureAirport")
	private Airport departureAirport;
	
	@ApiModelProperty(value = "Name Of Destination City")
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destinationAirport")
	private Airport destinationAirport;

	@ApiModelProperty(value = "Date and time of departure")
	private LocalDateTime departureDate;

	@ApiModelProperty(value = "Date and time of arrival")
	private LocalDateTime returnDate;

	@ApiModelProperty(value = "Price of the Ticket")
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
