package com.Amadeus.CaseStudy.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Amadeus.CaseStudy.model.Airport;
import com.Amadeus.CaseStudy.model.Flight;
import com.Amadeus.CaseStudy.service.AirportService;
import com.Amadeus.CaseStudy.service.FlightService;

@RestController
@RequestMapping("data")
public class DataController {

	@Autowired
	private FlightService flightService;
	@Autowired
	private AirportService airportService;
	
	@GetMapping(value = "/getFlights")
	public List<Flight> getFlights() {

		List<Flight> flights = flightService.getMockData();
		return flights;
		
	}
	@GetMapping(value = "/getAirports")
	public List<Airport> getAirports() {

		List<Airport> airports = airportService.getMockData();
		return airports;
		
	}
}
