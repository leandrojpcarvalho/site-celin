package com.celin.sitecelin.model;

import com.celin.sitecelin.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Users {
  public static final List<User> userList = new LinkedList<>();
  public static User newUser (User newUser) {
    Optional<User> user = userList.stream()
          .filter(user1 -> user1.getUserName().equals(newUser.getUserName()))
          .findAny();
    if (user.isPresent()){
      return user.get();
    }
    userList.add(newUser);
    return newUser;
  }

  public static Optional<User> findUser (String nane) {
    return userList.stream().filter(user1 -> user1.getUserName().equals(nane)).findAny();
  }

}
