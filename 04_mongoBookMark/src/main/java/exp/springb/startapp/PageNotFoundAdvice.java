package exp.springb.startapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice 
class PageNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler( PageNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String pageNotFoundHandler(PageNotFoundException ex) {
		return ex.getMessage();
	}
}
