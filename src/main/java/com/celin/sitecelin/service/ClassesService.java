package com.celin.sitecelin.service;

import com.celin.sitecelin.entities.ClassRoom;
import com.celin.sitecelin.entities.exceptions.IllegalServiceException;
import com.celin.sitecelin.model.ClassRooms;
import com.celin.sitecelin.model.dto.classes.ClassDetailsDto;
import com.celin.sitecelin.model.dto.classes.ClassModelDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassesService {
  public ClassModelDto[] getAllClasses() {
    return ClassRooms.getAllClasses().stream()
          .map(ClassModelDto::classModelDto)
          .toList()
          .toArray(new ClassModelDto[0]);
  }

  public ClassDetailsDto getClassRoomById(Long id) {
    Optional<ClassRoom> classRoom = ClassRooms.findClassRoomById(id);
    if(classRoom.isEmpty()) {
      throw new IllegalServiceException("Class not found", HttpStatus.NOT_FOUND);
    }
    return ClassDetailsDto.classDetailsDto(classRoom.get());
  }
}
