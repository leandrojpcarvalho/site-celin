package com.celin.sitecelin.model;

import com.celin.sitecelin.entities.users.Teacher;
import com.celin.sitecelin.entities.users.User;
import com.celin.sitecelin.entities.users.student.Student;
import com.celin.sitecelin.entities.users.utils.Address;

import java.util.*;
import java.util.stream.Collectors;

public class Users {
  public static final List<User> userList = new LinkedList<>();

  static {
    Teacher gabriela = new Teacher("Gabriela", "1234567", 2L);
    Address address = new Address();
    address.setZipCode("58065156");
    address.setComplement("ap 404");
    address.setNumber(472);
    gabriela.setAddress(address);
    gabriela.setPhones("11 98888888");
    gabriela.setEmail("gabriela@gmail.com");
    userList.add( new User("secretaria", 1L));
    userList.add(gabriela);
    userList.add(new Student("Leandro",3L));
    userList.add(new Student("Student 2", 4L));
  }
  public static User newUser (User newUser) {
    Optional<User> user = userList.stream()
          .filter(user1 -> user1.getName().equals(newUser.getName()))
          .findAny();
    if (user.isPresent()){
      return user.get();
    }
    userList.add(newUser);
    return newUser;
  }

  public static Optional<User> findUser (String name) {
    return userList.stream().filter(user1 -> user1.getName().equals(name)).findAny();
  }

  public static Optional<User> findUserById(Long userId) {
    return userList.stream().filter(user -> user.getId() == userId).findAny();
  }

  public static Teacher[] getAllTeacher() {
    return userList.stream()
          .filter(user -> user.getAccessLevel().equals("teacher"))
          .toList()
          .toArray(new Teacher[0]);
  }

  public static Optional<Teacher> findTeacherByRegistration(String registration) {
    return Arrays.stream(getAllTeacher())
          .filter(teacher -> teacher.getStateRegistration().equals(registration))
          .findAny();
  }

  public static List<Student> getAllStudent() {
    return userList.stream()
          .filter(user -> user.getAccessLevel().equals("student"))
          .map(user -> (Student) user)
          .toList();
  }
}
