package com.celin.sitecelin.service;

import com.celin.sitecelin.entities.users.Teacher;
import com.celin.sitecelin.entities.users.utils.dto.AvailabilityDto;
import com.celin.sitecelin.model.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import static com.celin.sitecelin.utils.InternalHelper.dtoMaker;

@Service
public class TeacherService {
  public Teacher[] getAllTeachers() {
    return Users.getAllTeacher();
  }

  public Teacher createTeacher(String data) throws JsonProcessingException {
    Teacher teacher = dtoMaker(data, Teacher.class);
    Users.newUser(teacher);
    return teacher;
  }

  public Teacher insertAvailability(String data, Teacher teacher) throws JsonProcessingException {
    teacher.setAvailability(dtoMaker(data, AvailabilityDto.class));
    return teacher;
  }
}
