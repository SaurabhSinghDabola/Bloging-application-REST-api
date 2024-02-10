package com.blog.Excepiton;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> ResourceNotFoundException(ResourceNotFoundException e, WebRequest wr){
		ErrorDetails error = new ErrorDetails(e.getMessage(), wr.getDescription(false), LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String , String >> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
		Map<String ,String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)-> {
			String filedName = ((FieldError) error).getField();
			String messgae = error.getDefaultMessage();
			resp.put(filedName, messgae);
		});
		
		return new ResponseEntity<>(resp , HttpStatus.BAD_REQUEST);
	}
	
//    ErrorDetails error = new ErrorDetails("Validation Exception", ex.getBindingResult().getFieldError().getDefaultMessage() ,LocalDate.now());
//		
//	return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
		
		
}
