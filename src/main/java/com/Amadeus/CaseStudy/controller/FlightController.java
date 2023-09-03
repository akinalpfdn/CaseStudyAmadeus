package com.Amadeus.CaseStudy.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Amadeus.CaseStudy.service.AuthService;
import com.Amadeus.CaseStudy.service.FlightService;
import com.Amadeus.CaseStudy.dto.ResultDto;
import com.Amadeus.CaseStudy.dto.Tuple;
import com.Amadeus.CaseStudy.model.Flight;

@RestController
@RequestMapping("flight")
public class FlightController {


	@Autowired
	private AuthService authService;
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/getFlightInfo")
    public ResultDto validateToken(@RequestHeader("Authorization") String token,
            @RequestParam String departureLocation,
            @RequestParam String arrivalLocation,
            @RequestParam String departureDate,
            @RequestParam String returnDate) {
        // Assuming the token is passed as "Bearer <token>"
        String[] parts = token.split(" ");
        if (parts.length != 2 || !"Bearer".equals(parts[0])) {
        	return new ResultDto(null,HttpStatus.UNAUTHORIZED,"Unauthorized: Invalid token format");
        }
        String tokenValue = parts[1];

        if (authService.isValidToken(tokenValue)) {
            var flights = flightService.getFlightInfo(  departureLocation,
              arrivalLocation,
              departureDate,
              returnDate);
            if(flights.size()==0)
            {
            	return new ResultDto("There is no flight with the given parameters",HttpStatus.ACCEPTED,"Successfull");
            }
            else if(flights.size()==1 && returnDate != null && !returnDate.isEmpty())
            {
        		Tuple<Flight, String> t = new Tuple<Flight,String> (flights.get(0), "There is no return flights with the given parameters"); 
            	return new ResultDto(t,HttpStatus.ACCEPTED,"Successfull");
            }
            else
            {
            	return new ResultDto(flights,HttpStatus.ACCEPTED,"Successfull");
            }
        } else {
        	return new ResultDto(null,HttpStatus.UNAUTHORIZED,"Unauthorized: Token is not valid");
        }
    }
}
