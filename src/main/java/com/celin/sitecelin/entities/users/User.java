package com.celin.sitecelin.entities.users;

import com.celin.sitecelin.entities.exceptions.IllegalUserField;
import com.celin.sitecelin.entities.users.utils.Address;
import com.celin.sitecelin.entities.users.utils.Phone;
import com.celin.sitecelin.model.Users;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class User {
  private final Long id;
  private String name;
  private String email;
  private Address address;
  private String password;
  private ArrayList<Phone> phones = new ArrayList<>();
  private String accessLevel;

  public User(String name, Long id) {
    this.id = id;
    this.name = name;
    this.password = name;
    this.setAccessLevel("user");
  }

  public User(
        @JsonProperty("address") Address address,
        @JsonProperty("email") String email,
        @JsonProperty("name") String name,
        @JsonProperty("phones") String[] phones,
        @JsonProperty("role") String role) {
    this.name = name;
    this.password = name;
    this.address = address;
    this.email = email;
    this.phones = (ArrayList<Phone>) Arrays.stream(phones).map(phone -> new Phone(phone)).collect(Collectors.toList());
    this.id = Users.getNewId();
    this.accessLevel = role;
  }

  public User() {
    this.id = 0L;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
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

  public void setName(String name) {
    String regex = "^\\p{L}{2,}(?: \\p{L}{2,})+$";
    if(!name.matches(regex)) {
      throw new IllegalUserField("the field name must have at least name and last name 'anna ann'");
    }
    this.name = name;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public void setPhones(String phone) {
    if (phones.stream()
          .anyMatch(phone1 -> phone1.toString().equals(phone))) {
      throw new IllegalUserField("this phone already registered");
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
    String regex = "^[\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
    if(email.matches(regex)) {
      this.email = email;
    } else {
      throw new IllegalUserField("This email is not valid");
    }
  }

  public void setAccessLevel(String accessLevel) {
    this.accessLevel = accessLevel;
  }

  public boolean passwordIsEmpty() {
    return password.isEmpty();
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
