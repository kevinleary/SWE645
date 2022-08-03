package com.hw3.backend;

class StudentNotFoundException extends RuntimeException {

	StudentNotFoundException(Long id) {
		super("Could not find student " + id);
	}
}
