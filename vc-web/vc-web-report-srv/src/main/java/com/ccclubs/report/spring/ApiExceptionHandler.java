package com.ccclubs.report.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.OK)
	public String resolveException(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) {
		logger.error("api error", ex);
		return ex.getMessage();

	}
}
