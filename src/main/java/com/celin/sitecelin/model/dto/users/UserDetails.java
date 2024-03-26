package com.celin.sitecelin.model.dto.users;

import com.celin.sitecelin.entities.users.User;
import com.celin.sitecelin.entities.users.utils.Address;
import com.celin.sitecelin.entities.users.utils.Phone;

import java.util.ArrayList;

public record UserDetails (
      Long id,
      String name,
      String email,
      Address address,
      String accessLevel,
      ArrayList<Phone>phones
      ) {
  public static UserDetails userDetails(User user) {
    return new UserDetails(
          user.getId(),
          user.getName(),
          user.getEmail(),
          user.getAddress(),
          user.getAccessLevel(),
          user.getPhones()
    );
  }
  public static UserModelDto userModelDto(User user) {
    return new UserModelDto(
          user.getId(),
          user.getName(),
          user.getPhones()
    );
  }
}
