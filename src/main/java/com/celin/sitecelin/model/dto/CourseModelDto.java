package com.celin.sitecelin.model.dto;

import com.celin.sitecelin.entities.course.Course;

public record CourseModelDto (
      Long id,
      String name
) {
  public static CourseModelDto courseModelDto(Course course) {
    return new CourseModelDto(course.getId(), course.getName());
  }
}
