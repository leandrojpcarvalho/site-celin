package com.celin.sitecelin.entities.users;

import com.celin.sitecelin.entities.ClassRoom;
import com.celin.sitecelin.entities.exceptions.IllegalTeacherExceptions;
import com.celin.sitecelin.entities.users.utils.dto.AvailabilityDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Teacher extends User {
  private ClassRoom[] classRooms;
  private final int classLimit = 7;
  private String stateRegistration;

  private String underdergrad;
  private AvailabilityDto availabilityDto;
  public Teacher(@JsonProperty("name") String userName, @JsonProperty("registration") String stateRegistration, Long id) {
    super(userName, id);
    this.stateRegistration = stateRegistration;
    setAccessLevel("teacher");
  }

  public Teacher(){}

  public AvailabilityDto getAvailability() {
    return availabilityDto;
  }

  public void setAvailability(AvailabilityDto availabilityDto) {
    this.availabilityDto = availabilityDto;
  }

  public ClassRoom[] getClassRooms() {
    return classRooms;
  }

  public void setClassRooms(ClassRoom[] classRooms) {
    if(classRooms.length >= classLimit) {
      throw new IllegalTeacherExceptions("This teacher cant get more classes");
    }
    this.classRooms = classRooms;
  }

  public String getStateRegistration() {
    return stateRegistration;
  }

  public void setStateRegistration(String stateRegistration) {
    String regex = "^\\d{7}$";
    if(!stateRegistration.matches(regex)){
      throw new IllegalTeacherExceptions("incorrect registration");
    }
    this.stateRegistration = stateRegistration;
  }
}
