package com.lessons.lessons.exception;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(int id) { //
		super(MessageFormat.format("Could not find object with id: {0}", id)); //getStackTrace()
	}
	
	
}
