package com.Amadeus.CaseStudy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Amadeus.CaseStudy.model.Airport;
import com.Amadeus.CaseStudy.repositories.AirportRepository;

@Service
public class AirportService {

	
	@Autowired
	private AirportRepository airportRepository;
	
	public void SaveAllAirports(List<Airport> airports)
	{
		
		airportRepository.saveAll(airports);
	}

	public List<Airport> getMockData() {
		List<Airport> airports = new ArrayList<>(Arrays.asList());
		airports.add(new Airport((long) 1,"Ankara"));
		airports.add(new Airport((long) 2,"Istanbul"));
		airports.add(new Airport((long) 3,"Eskisehir"));
		airports.add(new Airport((long) 4,"Izmir"));
		airports.add(new Airport((long) 5,"Antalya"));
		return airports;
	}
}
