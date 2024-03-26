package com.celin.sitecelin.entities.course;

import com.celin.sitecelin.entities.course.utils.Evaluation;

public class Course {
  private final Long id;
  private int schoolDays;
  private String name;
  private String courseDescription;

  public Course(String name, Long id) {
    this.name = name;
    this.id = id;
  }

  public Course() {
    this.id = 0L;
  }
  public int getSchoolDays() {
    return schoolDays;
  }

  public void setSchoolDays(int schoolDays) {
    this.schoolDays = schoolDays;
  }

  public String getCourseDescription() {
    return courseDescription;
  }

  public void setCourseDescription(String courseDescription) {
    this.courseDescription = courseDescription;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "{" +
          "id:" + id +
          ", schoolDays:" + schoolDays +
          ", name:'" + name + '\'' +
          ", courseDescription:'" + courseDescription + '\'' +
          '}';
  }
}
