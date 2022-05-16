package com.market.market.data;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestController
// @RequestMapping(“/foos”)
public class TestController {

	@Autowired
	private IFooService service;
	
	@GetMapping(value = "best/{id}")
	public Foo findById(@PathVariable("id") Long id) throws Exception {
	 // return RestPreconditions.checkFound(service.findById(id));
		throw new NoHandlerFoundException("GET", null, null);
	}
	
	
	@GetMapping("/test")
	@ResponseStatus(HttpStatus.OK)
	public List<Foo> findAll() {
		return this.service.findAll();
	}
	
	@GetMapping("/mest")
	public String find() {
		return "Test";
	}
	
	 @ExceptionHandler(NoHandlerFoundException.class)
	 @ResponseStatus(HttpStatus.NOT_FOUND)
	public HashMap<String, String> handleNoHandlerFound(NoHandlerFoundException e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "fail");
        response.put("message", "MMMM");
        return response;
    }
	
	
}
