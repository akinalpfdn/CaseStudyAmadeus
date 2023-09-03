package com.Amadeus.CaseStudy.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Amadeus.CaseStudy.model.Flight;

public interface FlightRepository extends JpaRepository<Flight,Long>
{

	@Query(value = "Select f from Flight f "
			+ "Where f.departureDate = :startHour "
			+ "AND f.departureAirport.city = :departure "
			+ "AND f.destinationAirport.city = :destionation "
			+		       " ")
	public List<Flight> findTop1ByByParameters(@Param("startHour")LocalDateTime startHour 
			,@Param("departure")String departure, 
			@Param("destionation")String destionation
			);

}
