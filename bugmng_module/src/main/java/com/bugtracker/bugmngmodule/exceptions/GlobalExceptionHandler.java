package com.bugtracker.bugmngmodule.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
//		Map<String,String> response=new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error)->{
//			String fieldName=((FieldError)error).getField();
//			String message=error.getDefaultMessage();
//			response.put(fieldName, message);
//		});
//		
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//	}
	
	@ExceptionHandler(BugNotFoundException.class)
	public ResponseEntity<String> handleAdminAuthenticationFailureException(Exception e){

         ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
         return responseEntity;
       
    }
}

