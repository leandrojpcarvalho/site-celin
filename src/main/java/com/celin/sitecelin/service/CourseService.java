package com.celin.sitecelin.service;

import com.celin.sitecelin.entities.course.Course;
import com.celin.sitecelin.entities.course.utils.dto.CourseCreationDto;
import com.celin.sitecelin.entities.exceptions.IllegalModelException;
import com.celin.sitecelin.entities.exceptions.IllegalServiceException;
import com.celin.sitecelin.model.Courses;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
  public Course[] getAllCourses () {
    return Courses.getAllCourses();
  }

  public Course getCourseById(Long id) {
    return Courses.getCourseById(id)
          .orElseThrow(()-> new IllegalServiceException("course with id: " + id +" not found", HttpStatus.NOT_FOUND));
  }

  public Course[] getCourseByName(String courseName) {
    if(courseName.isEmpty()) {
      throw new IllegalServiceException("course name cannot be null", HttpStatus.BAD_REQUEST);
    }
    return Courses.getCourseByName(courseName);
  }

  public Course createCourse(CourseCreationDto dto) {
    return Courses.addCourse(dto);
  }
}
