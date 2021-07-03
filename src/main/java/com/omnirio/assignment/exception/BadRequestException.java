package com.omnirio.assignment.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BadRequestException Class
 */
public class BadRequestException extends Exception {

	private static final long serialVersionUID = 3334261301168302623L;

	private final transient Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * BadRequestException Method
	 *
	 * @param message String value
	 */
	public BadRequestException(String message) {

		super(message);

		log.debug(" BadRequestException {}", message);
	}
}
