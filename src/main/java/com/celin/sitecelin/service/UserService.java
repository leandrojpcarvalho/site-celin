package com.celin.sitecelin.service;

import com.celin.sitecelin.entities.exceptions.IllegalServiceException;
import com.celin.sitecelin.entities.exceptions.IllegalUserField;
import com.celin.sitecelin.entities.users.User;
import com.celin.sitecelin.entities.users.utils.Address;
import com.celin.sitecelin.entities.users.utils.dto.UpdateUserDto;
import com.celin.sitecelin.model.Users;
import com.celin.sitecelin.model.dto.users.UserDetails;
import com.celin.sitecelin.model.dto.users.UserModelDto;
import com.celin.sitecelin.utils.InternalHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.celin.sitecelin.utils.InternalHelper.dtoMaker;

@Service
public class UserService {
  public List<UserModelDto> getAllUsers(String name) {
     Stream<User> stream = Users.userList.stream();
     if(name != null) {
       return stream.filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
             .map(UserModelDto::userDto).toList();
     }
    return stream.map(UserModelDto::userDto).toList();
  }

  public User postNewUser(String data) throws JsonProcessingException {
    User newUser = dtoMaker(data, User.class);
    return Users.newUser(newUser);
  }

  public User updateUser(Long id, String data) throws IOException {
    try {
      Optional<User> user = Users.findUserById(id);
      if (user.isEmpty()) {
        throw new RuntimeException("this User does not exists");
      }
      return InternalHelper.updateUser(user.get(), dtoMaker(data, UpdateUserDto.class));

    } catch (IllegalUserField e) {
      throw new BadRequestException(e);
    }
  }


  public UserDetails getUserById(Long id) {
    Optional<User> user = Users.findUserById(id);
    if(user.isEmpty()) {
      throw new IllegalServiceException("User not found", HttpStatus.NOT_FOUND);
    }
   return UserDetails.userDetails(user.get());
  }


}
