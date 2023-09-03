package com.Amadeus.CaseStudy.dto;

import org.springframework.http.HttpStatus;

public class ResultDto {
	
	  
	private Object result;
    

	private HttpStatus status;
	
	private String message;
	
	public ResultDto(){}

    public ResultDto(Object result, HttpStatus status, String message){
        super();
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public ResultDto(Object result, HttpStatus status){
        super();
        this.status = status;
        this.result = result;
    }

	public Object getResult() {
		return result;
	}

	public void setStart(Object result) {
		this.result = result;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getSMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
