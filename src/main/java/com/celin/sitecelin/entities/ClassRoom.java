package com.celin.sitecelin.entities;

import com.celin.sitecelin.entities.users.student.Student;
import com.celin.sitecelin.model.Users;

import java.util.List;

public class ClassRoom {
  private final Long id;
  private Long teacherId;
  private final Long courseId;
  private final List<Long> students;

  public ClassRoom(Long id, Long courseId, List<Long> students) {
    this.students = students;
    this.id = id;
    this.courseId = courseId;
  }

  public Long getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(Long teacherId) {
    this.teacherId = teacherId;
  }

  public Long getId() {
    return id;
  }


  public void addStudent(Student newStudent) {
    if (students.contains(newStudent)) {
      throw new RuntimeException("this students belongs to class");
    }
    students.add(newStudent.getId());
  }

  public void removeStudent(Student student) {
    if (!students.contains(student.getId())) {
      throw new RuntimeException("this students does not belongs to class");
    }
    students.remove(Users.findUserById(student.getId()));
  }

  public Long getCourseId() {
    return courseId;
  }

  public List<Long> getStudents() {
    return students;
  }

  @Override
  public String toString() {
    return "{" +
          "id:" + id +
          ", teacherId:" + teacherId +
          ", courseSchedule:" + courseId +
          '}';
  }


}
