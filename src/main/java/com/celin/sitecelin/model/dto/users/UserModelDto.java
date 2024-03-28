package com.celin.sitecelin.model.dto.users;

import com.celin.sitecelin.entities.users.User;
import com.celin.sitecelin.entities.users.utils.Phone;

import java.util.ArrayList;

public record UserModelDto (
      Long id,
      String name,
      String email,
      String role
){
  public static UserModelDto userDto(User user) {
    return new UserModelDto(user.getId(), user.getName(), user.getEmail() == null ? "": user.getEmail(), user.getAccessLevel());
  }
}
