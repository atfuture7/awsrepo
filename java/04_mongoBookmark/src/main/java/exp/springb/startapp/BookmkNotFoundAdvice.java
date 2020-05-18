package exp.springb.startapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice 
class BookmkNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler( BookmkNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String bookmkNotFoundHandler(BookmkNotFoundException ex) {
		return ex.getMessage();
	}
}
