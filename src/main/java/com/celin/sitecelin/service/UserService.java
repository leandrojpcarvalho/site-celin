package com.celin.sitecelin.service;

import com.celin.sitecelin.entities.Address;
import com.celin.sitecelin.entities.UpdateForm;
import com.celin.sitecelin.entities.User;
import com.celin.sitecelin.model.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  public List<User> getAllUsers() {
    return Users.userList;
  }

  public User postNewUser(String data) throws JsonProcessingException {
    User newUser = jsonConvert(data, User.class);
    return Users.newUser(newUser);
  }

  public User updateUser(String name, String data) throws IOException {
    Optional<User> user = Users.findUser(name);
    if (user.isEmpty()) {
      throw new RuntimeException("this User does not exists");
    }
    UpdateForm updateForm = jsonConvert(data, UpdateForm.class);
    try {
      if (updateForm.phones() != null) {
        updateForm.phones().stream().forEach(phone -> user.get().setPhones(phone));
      }
      if (updateForm.zipCode() != null) {
        Address address = new Address(updateForm.zipCode());
        user.get().setAddress(address);
        if (updateForm.number() != null) {
          address.setNumber(Integer.parseInt(updateForm.number()));
        }
        if (updateForm.complement() != null) {
          address.setComplement(updateForm.complement());
        }
        if (updateForm.email() != null) {
          user.get().setEmail(updateForm.email());
        }
      }
      return user.get();
    } catch (IllegalArgumentException e) {
      throw new BadRequestException(e);
    }
  }

  public <T> T jsonConvert(String data, Class<T> classToFill) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    return mapper.readValue(data, classToFill);
  }

}
