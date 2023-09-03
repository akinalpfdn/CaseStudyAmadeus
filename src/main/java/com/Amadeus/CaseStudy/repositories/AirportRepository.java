package com.Amadeus.CaseStudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Amadeus.CaseStudy.model.Airport;
@Repository
public interface AirportRepository  extends JpaRepository<Airport,Long>
{

}
