package com.texoit.raspberryawards.exception;

public class ProducerNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProducerNotFoundException(Long id) {
		super("Could not find Producer " + id);
	}
}
