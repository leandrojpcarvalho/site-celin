package com.celin.sitecelin.controller;

import com.celin.sitecelin.entities.course.Course;
import com.celin.sitecelin.entities.course.utils.dto.CourseCreationDto;
import com.celin.sitecelin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
  private CourseService service;

  @Autowired
  public CourseController(CourseService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<Course[]> getAllCourses () {
    return ResponseEntity.ok(service.getAllCourses());
  }
  @PostMapping("/find")
  public ResponseEntity<Course[]> getCoursesByName (@RequestBody CourseCreationDto dto) {
    return ResponseEntity.ok(service.getCourseByName(dto.name()));
  }

//  @PostMapping
//  public ResponseEntity<Course> postCourse (@RequestBody CourseCreationDto dto) {
//    return ResponseEntity
//          .status(HttpStatus.CREATED)
//          .body(service.createCourse(dto));
//  }
}
