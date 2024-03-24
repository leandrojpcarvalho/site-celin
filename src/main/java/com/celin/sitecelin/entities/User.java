package com.celin.sitecelin.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;
public class User {
  private final UUID id;
  private String email;
  private String userName;
  private Address address;
  private String password;
  private final ArrayList<Phone> phones = new ArrayList<>();
  private String accessLevel;

  public User(@JsonProperty("name") String userName) {
    this.id = UUID.randomUUID();
    this.userName = userName;
    this.password = userName;
    this.accessLevel = "user";
  }

  public UUID getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public Address getAddress() {
    return address;
  }

  public ArrayList<Phone> getPhones() {
    return phones;
  }

  public String getAccessLevel() {
    return accessLevel;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public void setPhones(String phone) {
    if (phones.stream()
          .anyMatch(phone1 -> phone1.toString().equals(phone))) {
      throw new IllegalArgumentException("this phone already registered");
    }
    int ddd = Integer.parseInt(phone.substring(0, 2));
    Integer number = Integer.parseInt(phone.substring(3));
    Phone newPhone = new Phone();
    newPhone.setDdd(ddd);
    newPhone.setNumber(number);
    phones.add(newPhone);
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
