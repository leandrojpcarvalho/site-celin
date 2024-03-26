package com.celin.sitecelin.controller;

import com.celin.sitecelin.model.dto.classes.ClassDetailsDto;
import com.celin.sitecelin.model.dto.classes.ClassModelDto;
import com.celin.sitecelin.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classes")
public class ClassesController {
  private ClassesService service;

  @Autowired
  public ClassesController(ClassesService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<ClassModelDto[]> getAllClasses () {
    return ResponseEntity.ok(service.getAllClasses());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ClassDetailsDto> getClassDetails(@PathVariable Long id) {
    return ResponseEntity.ok(service.getClassRoomById(id));
  }
}
