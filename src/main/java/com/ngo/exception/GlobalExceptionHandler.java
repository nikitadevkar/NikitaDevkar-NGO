package com.ngo.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ngo.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
	
		String message = ex.getMessage();
		ApiResponse api=new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(api , HttpStatus.BAD_REQUEST);
		
	}
	
	
//	 @ExceptionHandler(MethodArgumentNotValidException.class)
//	    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
//	        List<String> errors = ex.getBindingResult().getFieldErrors()
//	                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
//	        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
//	    }
//
//	    private Map<String, List<String>> getErrorsMap(List<String> errors) {
//	        Map<String, List<String>> errorResponse = new HashMap<>();
//	        errorResponse.put("errors", errors);
//	        return errorResponse;
//	    }
	
}
