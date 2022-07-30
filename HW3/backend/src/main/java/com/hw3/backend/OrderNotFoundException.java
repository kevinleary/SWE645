package com.hw3.backend;

class OrderNotFoundException extends RuntimeException{
	
	OrderNotFoundException(Long id) {
		    super("Could not find employee " + id);
		  }
}
