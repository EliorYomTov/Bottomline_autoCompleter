package com.elior.autoCompletedApp.exceptions;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice // AOP for Spring Controller
public class ExceptionsCatcher {

	@ExceptionHandler({ ConversionFailedException.class, IllegalArgumentException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDetails handleConvert(Exception e) {
		return new ErrorDetails(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
				"BAD_REQUEST", "Illegal value - Enter a value with letters only!", 400);
	}
}
