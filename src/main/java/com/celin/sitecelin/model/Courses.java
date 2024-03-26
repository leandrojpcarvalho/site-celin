package com.celin.sitecelin.model;

import com.celin.sitecelin.entities.course.Course;
import com.celin.sitecelin.entities.course.utils.dto.CourseCreationDto;
import com.celin.sitecelin.entities.exceptions.IllegalModelException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Courses {
  private static final List<Course> subjects = new ArrayList<>();

  static {
    subjects.add(new Course("English I", 1L));
    subjects.add(new Course("English II", 2L));
    subjects.add(new Course("English III", 3L));
  }

  public static Course[] getAllCourses() {
    return subjects.toArray(new Course[0]);
  }

  public static Course addCourse(CourseCreationDto dto) {
    if (subjects.stream().anyMatch(subject -> subject.getName().equals(dto.name()))) {
      throw new IllegalModelException("this course exists");
    }
    Course course = new Course(dto.name(), subjects.stream().count());
    subjects.add(course);
    return course;
  }

  public static Course[] getCourseByName(String name) {
    return subjects.stream()
          .filter(subject -> subject.getName().contains(name))
          .toList()
          .toArray(new Course[0]);
  }

  public static Optional<Course> getCourseById(Long id) {
    return subjects.stream().filter(subject -> subject.getId() == id).findAny();
  }
}
