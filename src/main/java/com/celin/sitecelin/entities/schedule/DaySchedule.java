package com.celin.sitecelin.entities.schedule;

import com.celin.sitecelin.entities.ClassRoom;
import com.celin.sitecelin.model.ClassRooms;
import com.celin.sitecelin.model.Days;
import com.celin.sitecelin.model.Shifts;
import com.celin.sitecelin.model.Time;

import java.util.Optional;
import java.util.UUID;

public class DaySchedule {
  private String day;
  private String[] time;
  private ClassRoom classRoom;
  public DaySchedule(String day, String time, Long classRoomId) {
    this.day = Days.getDay(day);
    this.time = Time.getTimeStartAt(time).get(0);
    Optional<ClassRoom> classRoomOptional = ClassRooms.findClassRoomById(classRoomId);
    if(classRoomOptional.isEmpty()) {
      throw new RuntimeException("this classRoom does not exists");
    }
    this.classRoom = ClassRooms.findClassRoomById(classRoomId).get();
  }
}
