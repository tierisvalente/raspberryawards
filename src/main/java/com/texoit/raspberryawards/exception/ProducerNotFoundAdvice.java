package com.texoit.raspberryawards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProducerNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(ProducerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String producerNotFoundHandler(ProducerNotFoundException e) {
		return e.getMessage();
	}
}
