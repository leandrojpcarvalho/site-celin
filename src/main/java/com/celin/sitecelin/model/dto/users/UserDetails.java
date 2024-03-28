package com.celin.sitecelin.model.dto.users;

import com.celin.sitecelin.entities.users.User;
import com.celin.sitecelin.entities.users.utils.Address;
import com.celin.sitecelin.entities.users.utils.Phone;
import com.celin.sitecelin.entities.users.utils.dto.AddressDto;
import com.celin.sitecelin.utils.ExternalApiHelper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import static com.celin.sitecelin.utils.ExternalApiHelper.cepUrl;
import static com.celin.sitecelin.utils.ExternalApiHelper.dtoFactory;

public record UserDetails (
      Long id,
      String name,
      String email,
      Address address,
      String accessLevel,
      ArrayList<Phone>phones
      ) {
  public static UserDetails userDetails(User user) {
    try {
      if(!user.getAddress().getZipCode().isEmpty()) {
        AddressDto address = dtoFactory(cepUrl(user.getAddress().getZipCode()), AddressDto.class);
        user.getAddress().setAddress(address.address());
        user.getAddress().setCity(address.city());
        user.getAddress().setState(address.state());
      }
    } catch (IOException exception ) {
      System.out.println(exception);
    }
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
          user.getEmail(),
          user.getAccessLevel()
    );
  }
}
