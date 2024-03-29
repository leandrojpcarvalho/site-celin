package com.celin.sitecelin.model.dto.classes;

import com.celin.sitecelin.entities.ClassRoom;
import com.celin.sitecelin.entities.course.Course;
import com.celin.sitecelin.entities.exceptions.IllegalModelException;
import com.celin.sitecelin.entities.users.Teacher;
import com.celin.sitecelin.model.Courses;
import com.celin.sitecelin.model.Users;
import com.celin.sitecelin.model.dto.CourseModelDto;
import com.celin.sitecelin.model.dto.users.UserModelDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ClassModelDto(
      @JsonProperty("id") Long id,
      @JsonProperty("className") String className,
      @JsonProperty("teacher") UserModelDto teacher
) {
  public static ClassModelDto classModelDto(ClassRoom classRoom) {
    try {
      UserModelDto teacher = UserModelDto
            .userDto(Users.findUserById(classRoom.getTeacherId()).orElse(new Teacher()));
      CourseModelDto course = CourseModelDto.courseModelDto(Courses.getCourseById(classRoom.getCourseId()).orElse(new Course()));
      return new ClassModelDto(classRoom.getId(), course.name(), teacher);
    } catch (IllegalModelException e) {
      throw new RuntimeException("dto Classes fail: " + e);
    }
  }
}
