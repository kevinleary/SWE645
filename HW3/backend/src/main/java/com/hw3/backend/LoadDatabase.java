package com.hw3.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository, StudentRepository studentRepository) {
	
	  //Calendar.getInstance();
    return args -> {
//      employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
//      employeeRepository.save(new Employee("Frodo", "Baggins", "thief"));
//
//      employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));
//
//      
//      orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
//      orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));
//
//      orderRepository.findAll().forEach(order -> {
//        log.info("Preloaded " + order);
//      });
//    
      ArrayList<String> likesArray = new ArrayList<String>();
      likesArray.add("Sports");
      likesArray.add("Dorm Rooms");
      studentRepository.save(new Student("Kevin", "Leary", "123 Fuck You Road", "Arlington", "VA", "11102",
    		  "123456789", "kleary5@gmu.edu", "July 31st 2022", likesArray, "Other", "Likely" ));
      
      studentRepository.findAll().forEach(student -> {
          log.info("Preloaded " + student);
        });
      
    };
  }
}
