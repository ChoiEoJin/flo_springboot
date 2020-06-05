package com.example.demo.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.demo.util.ResponseMapper;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Internal Sever Error Exception Handler (500)
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleInternalServerError(Exception e) {

		return ResponseMapper.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	/**
	 * Not Found Error Exception Handler (404)
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Object> handleNotFoundError(Exception e) {

		return ResponseMapper.errorResponse(HttpStatus.NOT_FOUND.value());
	}

	/**
	 * BadRequest Error Exception Handler (400)
	 */
	@ExceptionHandler(value = { MissingServletRequestParameterException.class,
			MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleBadRequestError(Exception e) {

		return ResponseMapper.errorResponse(HttpStatus.BAD_REQUEST.value());
	}
	
	/**
	 * Method Not Allowed Error Exception Handler (405)
	 */
	@ExceptionHandler(value = { MethodNotAllowedException.class, HttpRequestMethodNotSupportedException.class })
	public ResponseEntity<Object> handleInavlidMethodtError(Exception e) {

		return ResponseMapper.errorResponse(HttpStatus.METHOD_NOT_ALLOWED.value());
	}

}
