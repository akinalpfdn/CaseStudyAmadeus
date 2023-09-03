package com.Amadeus.CaseStudy.scheduled;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.Amadeus.CaseStudy.controller.DataController;
import com.Amadeus.CaseStudy.service.AirportService;
import com.Amadeus.CaseStudy.service.FlightService;
import javax.annotation.PostConstruct;

@Component
public class ScheduledTasks {

	@Autowired
	private FlightService flightService;
	@Autowired
	private AirportService airportService;
	@Autowired
	private DataController dataController;
	

    @PostConstruct
    @Scheduled(cron = "0 0 0 * * *")
	    public void getDataDaily() {
	        //System.out.println("Periodic task: " + new Date());
		 	var airports =  dataController.getAirports();
		 	airportService.SaveAllAirports(airports);
		 	var flights = dataController.getFlights();
		 	flightService.SaveAllFlights(flights);
	    }
	

}
