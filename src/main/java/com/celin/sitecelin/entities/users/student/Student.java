package com.celin.sitecelin.entities.users.student;

import com.celin.sitecelin.entities.ClassRoom;
import com.celin.sitecelin.entities.users.User;
import com.celin.sitecelin.entities.users.student.utils.ReportCard;
import com.celin.sitecelin.model.ClassRooms;
import com.celin.sitecelin.model.Users;

import java.util.Optional;

public class Student extends User {
  private Long classRoomId;
  private final ReportCard reportCard = new ReportCard();

  public Student(String userName, Long id) {
    super(userName, id);
    this.setAccessLevel("student");
  }

  public Student() {
  }


  public void evaluationGrade(Long teacherId, Long evaluationId, int grade) {
    Optional<User> user = Users.findUserById(teacherId);
    Optional<ClassRoom> classRoom = ClassRooms.findClassRoomById(classRoomId);
    if (classRoom.isEmpty()) {
      throw new RuntimeException("this student not belongs to a valid class");
    }
    if (user.isEmpty()) {
      throw new RuntimeException("this user does not exist");
    }
    if (
          !user.get().getAccessLevel().equals("teacher")
                &&
                user.get().getId().equals(ClassRooms.findClassRoomById(classRoomId).get().getTeacherId().equals(user.get().getId()))
    ) {
      throw new RuntimeException("this user not have authorization to set this appointment");
    }
    reportCard.addGrade(evaluationId, grade);
  }

  public void changeClassRoom(Long classRoomId) {
    Optional<ClassRoom> classRoom = ClassRooms.findClassRoomById(classRoomId);
    if (classRoom.isEmpty()) {
      throw new RuntimeException("This class does not exist");
    }
    this.classRoomId = classRoomId;
  }
}
