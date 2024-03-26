package com.celin.sitecelin.model.dto.classes;

import com.celin.sitecelin.entities.ClassRoom;
import com.celin.sitecelin.entities.course.Course;
import com.celin.sitecelin.entities.exceptions.IllegalModelException;
import com.celin.sitecelin.entities.users.Teacher;
import com.celin.sitecelin.entities.users.student.Student;
import com.celin.sitecelin.model.Courses;
import com.celin.sitecelin.model.Users;
import com.celin.sitecelin.model.dto.CourseModelDto;
import com.celin.sitecelin.model.dto.users.UserModelDto;

import java.util.List;

public record ClassDetailsDto (
      Long id,
      Teacher teacher,
      CourseModelDto course,
      List<Student> students
) {
  public static ClassDetailsDto classDetailsDto(ClassRoom classRoom) {
    try {
      Teacher teacher = (Teacher) Users.findUserById(classRoom.getTeacherId()).orElse(new Teacher());
      CourseModelDto course = CourseModelDto.courseModelDto(Courses.getCourseById(classRoom.getCourseId()).orElse(new Course()));
      List<Student> students = classRoom.getStudents().stream()
            .map(studentId -> (Student) Users.findUserById(studentId).orElse(new Student()))
            .toList();
      return new ClassDetailsDto(classRoom.getId(), teacher, course, students);
    } catch (IllegalModelException e) {
      throw new RuntimeException("dto Classes fail: " + e);
    }
  }
}