package com.omnirio.assignment.exception.handler;

import com.omnirio.assignment.exception.ApiError;
import com.omnirio.assignment.exception.BadRequestException;
import com.omnirio.assignment.exception.EntityNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * RestExceptionHandler Class For Handling Exceptions
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


	/**
	 * Handles javax.validation.ConstraintViolationException. Thrown when @Validated
	 * fails.
	 *
	 * @param ex the ConstraintViolationException
	 * @return the ApiError object
	 */
	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolation(javax.validation.ConstraintViolationException ex) {

		ApiError apiError = new ApiError(BAD_REQUEST);
		apiError.setMessage("Validation error");
		apiError.addValidationErrors(ex.getConstraintViolations());

		return buildResponseEntity(apiError);
	}



	/**
	 * Handles EntityNotFoundException. Created to encapsulate errors with more
	 * detail than javax.persistence.EntityNotFoundException.
	 *
	 * @param ex the EntityNotFoundException Object
	 * @return the ApiError Object
	 */
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {

		ApiError apiError = new ApiError(NOT_FOUND);
		apiError.setMessage(ex.getMessage());

		return buildResponseEntity(apiError);
	}

	/**
	 * Handles BadRequestException. Created to encapsulate errors with more detail
	 * than javax.persistence.BadRequestException.
	 *
	 * @param ex the BadRequestException Object
	 * @return the ApiError Object
	 */
	@ExceptionHandler(BadRequestException.class)
	protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {

		ApiError apiError = new ApiError(BAD_REQUEST);
		apiError.setMessage(ex.getMessage());

		return buildResponseEntity(apiError);
	}
	

	
	/**
	 * BuildResponseEntity
	 *
	 * @param apiError ApiError Object
	 * @return ResponseEntity ResponseEntity Object
	 */
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	

	

}
