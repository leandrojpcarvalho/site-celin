package com.celin.sitecelin.model;

import com.celin.sitecelin.entities.ClassRoom;
import com.celin.sitecelin.entities.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassRooms {
  private static final List<ClassRoom> classRooms = new ArrayList<>();

  static {
    List<Long> studentsIds = Users.getAllStudent().stream().map(User::getId).toList();
    Long courseId = Courses.getAllCourses()[0].getId();
    classRooms.add(new ClassRoom(classRooms.stream().count(), courseId, studentsIds));
  }

  public static Optional<ClassRoom> findClassRoomById(Long classId) {
    return classRooms.stream().filter(classRoom -> classRoom.getId() == (classId)).findAny();
  }

  public static ClassRoom createClassRom(ClassRoom newClassRoom) {
    Optional<ClassRoom> classRoom = classRooms.stream().filter(classRoom1 -> classRoom1.equals(newClassRoom)).findFirst();
    if (classRoom.isPresent()) {
      return classRoom.get();
    }
    classRooms.add(newClassRoom);
    return newClassRoom;
  }

  public static List<ClassRoom> getAllClasses() {
    return classRooms;
  }
}
