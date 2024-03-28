package com.celin.sitecelin.controller;

import com.celin.sitecelin.entities.users.Teacher;
import com.celin.sitecelin.model.Users;
import com.celin.sitecelin.service.TeacherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/teachers")
public class TeacherController {
  private TeacherService service;
  @Autowired
  public TeacherController(TeacherService service) {
    this.service=service;
  }

  @GetMapping
  public ResponseEntity<Teacher[]> getAllTeachers() {
    return ResponseEntity.ok(service.getAllTeachers());
  }

  @PostMapping
  public ResponseEntity<Teacher> postTeacher(@RequestBody String data) throws JsonProcessingException {
    return ResponseEntity.status(201).body(service.createTeacher(data));
  }

  @PutMapping("/{registration}")
  public ResponseEntity<Teacher> putAvailability(@RequestBody String data, @PathVariable String registration) throws JsonProcessingException {
    Optional<Teacher> teacher = Users.findTeacherByRegistration(registration);
    if(teacher.isEmpty()) {
      throw new RuntimeException("this teacher does not exist");
    }
    return ResponseEntity.ok(service.insertAvailability(data, teacher.get()));
  }
}
