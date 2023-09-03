package com.Amadeus.CaseStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Amadeus.CaseStudy.model.Airport;
import com.Amadeus.CaseStudy.model.Flight;
import com.Amadeus.CaseStudy.repositories.FlightRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public void SaveAllFlights(List<Flight> flights)
	{
		
		flightRepository.saveAll(flights);
	}

	public List<Flight> getMockData() {
		List<Flight> flights = new ArrayList<>(Arrays.asList());
		flights.add(new Flight((long)1,new Airport((long) 1,"Ankara"),new Airport((long) 2,"Istanbul"), LocalDateTime.of(2023,11,22,12,00,00),LocalDateTime.of(2023,11,22,13,00,00),(float) 100.00));
		flights.add(new Flight((long)2,new Airport((long) 2,"Istanbul"),new Airport((long) 1,"Ankara"), LocalDateTime.of(2023,11,24,12,00,00),LocalDateTime.of(2023,11,24,13,00,00),(float) 100.00));
		flights.add(new Flight((long)3,new Airport((long) 1,"Ankara"),new Airport((long) 5,"Antalya"), LocalDateTime.of(2023,11,22,10,00,00),LocalDateTime.of(2023,11,22,11,00,00),(float) 150.00));
		flights.add(new Flight((long)4,new Airport((long) 5,"Antalya"),new Airport((long) 1,"Ankara"), LocalDateTime.of(2023,11,24,12,00,00),LocalDateTime.of(2023,11,24,13,00,00),(float) 150.00));
		flights.add(new Flight((long)5,new Airport((long) 3,"Eskisehir"),new Airport((long) 1,"Ankara"), LocalDateTime.of(2023,11,22,12,30,00),LocalDateTime.of(2023,11,22,13,00,00),(float) 50.00));
		flights.add(new Flight((long)6,new Airport((long) 1,"Ankara"),new Airport((long) 3,"Eskisehir"), LocalDateTime.of(2023,11,24,12,30,00),LocalDateTime.of(2023,11,24,13,00,00),(float) 50.00));
		
		return flights;
	}

	public List<Flight> getFlightInfo(String departureLocation, String arrivalLocation, String departureDate,
			String returnDate) {

		List<Flight> flights = new ArrayList<>(Arrays.asList());
		var dateInfo = departureDate.split("-");
		var firstFlight = flightRepository.findTop1ByByParameters(LocalDateTime.of(Integer.parseInt(dateInfo[0]), 
				Integer.parseInt(dateInfo[1]), 
				Integer.parseInt(dateInfo[2]), 
				Integer.parseInt(dateInfo[3]), 
				Integer.parseInt(dateInfo[4]))
				,departureLocation,arrivalLocation
				);
		if(firstFlight.size()>0)
		{
			flights.add(firstFlight.get(0));
		}
		if(returnDate != null && !returnDate.isEmpty())
		{

			dateInfo = returnDate.split("-");
			var secondFlight = flightRepository.findTop1ByByParameters(LocalDateTime.of(Integer.parseInt(dateInfo[0]), 
					Integer.parseInt(dateInfo[1]), 
					Integer.parseInt(dateInfo[2]), 
					Integer.parseInt(dateInfo[3]), 
					Integer.parseInt(dateInfo[4]))
					,arrivalLocation ,departureLocation
					);

			if(secondFlight.size()>0)
			{
				flights.add(secondFlight.get(0));
			}
			
		}
		return flights;
	}
}
