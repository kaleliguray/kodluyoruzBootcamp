package com.lessons.lessons.shared;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class GenericResponse {
	
	private String message;
	
	public GenericResponse(String message, LocalTime date, LocalDate date2) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	    String formattedTime=date.format(formatter);
	    this.message = message +" "+date2.getYear()+"/"+date2.getMonth()+"/"+date2.getDayOfMonth()+" "+ formattedTime;
	    
		
	}


	
	
	

}
