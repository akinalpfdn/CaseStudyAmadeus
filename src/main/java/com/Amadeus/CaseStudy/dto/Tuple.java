package com.Amadeus.CaseStudy.dto;

public class Tuple<Departure, Return> { 
	  public final Departure first; 
	  public final Return second; 
	  public Tuple(Departure first, Return second) { 
	    this.first = first; 
	    this.second = second; 
	  } 
	} 