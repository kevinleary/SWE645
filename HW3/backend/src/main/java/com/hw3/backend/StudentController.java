package com.hw3.backend;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.CollectionModel;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class StudentController {

  private final StudentRepository repository;

  private final StudentModelAssembler assembler;

  StudentController(StudentRepository repository, StudentModelAssembler assembler) {

    this.repository = repository;
    this.assembler = assembler;
  }


  // Aggregate root
  // tag::get-aggregate-root[]

  @GetMapping("/students")
  CollectionModel<EntityModel<Student>> all() {

    List<EntityModel<Student>> students = repository.findAll().stream() //
        .map(assembler::toModel) //
        .collect(Collectors.toList());

    return CollectionModel.of(students, linkTo(methodOn(StudentController.class).all()).withSelfRel());
  }
  // end::get-aggregate-root[]
  

  @PostMapping("/students")
  ResponseEntity<?> newStudent(@RequestBody Student newStudent) {

    EntityModel<Student> entityModel = assembler.toModel(repository.save(newStudent));

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }
  // Single item
  @GetMapping("/students/{id}")
  EntityModel<Student> one(@PathVariable Long id) {

	  Student students = repository.findById(id) //
        .orElseThrow(() -> new StudentNotFoundException(id));

    return assembler.toModel(students);
  }

  @PutMapping("/students/{id}")
  ResponseEntity<?> replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {

	  Student updatedStudent = repository.findById(id) //
        .map(student -> {
          student.setName(newStudent.getName());
          student.setStreet(newStudent.getStreet());
          student.setCity(newStudent.getCity());
          student.setState(newStudent.getState());
          student.setZip(newStudent.getZip());
          student.setPhone(newStudent.getPhone());
          student.setEmail(newStudent.getEmail());
          student.setDate(newStudent.getDate());
          student.setLiked(newStudent.getLiked());
          student.setInterested(newStudent.getInterested());
          student.setRecommend(newStudent.getRecommend());
          return repository.save(student);
        }) //
        .orElseGet(() -> {
          newStudent.setId(id);
          return repository.save(newStudent);
        });

    EntityModel<Student> entityModel = assembler.toModel(updatedStudent);

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }
  
  @DeleteMapping("/students/{id}")
  ResponseEntity<?> deleteStudent(@PathVariable Long id) {

    repository.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}