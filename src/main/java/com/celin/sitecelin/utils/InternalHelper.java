package com.celin.sitecelin.utils;

import com.celin.sitecelin.entities.course.utils.Evaluation;
import com.celin.sitecelin.entities.course.utils.dto.EvaluationUpdateDto;
import com.celin.sitecelin.entities.users.User;
import com.celin.sitecelin.entities.users.utils.Address;
import com.celin.sitecelin.entities.users.utils.dto.AddressDto;
import com.celin.sitecelin.entities.users.utils.dto.UpdateUserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static com.celin.sitecelin.utils.ExternalApiHelper.cepUrl;
import static com.celin.sitecelin.utils.ExternalApiHelper.dtoFactory;

public class InternalHelper {
  public static <T> T dtoMaker(String data, Class<T> classType) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    return (T) mapper.readValue(data, classType);
  }

  public static Address updateAddress(String zipCode, Address address) throws IOException {
    if (!zipCode.isEmpty() && zipCode.equals(address.getZipCode())) {
      AddressDto newAddress = dtoFactory(cepUrl(zipCode), AddressDto.class);
      address.setAddress(newAddress.address());
      address.setZipCode(zipCode);
      address.setCity(newAddress.city());
      address.setState(newAddress.state());
    }
    return address;
  }

  public static User updateUser(User user, UpdateUserDto updateUserDto) throws IOException {
    Address updatedAddress = updateAddress(updateUserDto.zipCode(), user.getAddress());
    updatedAddress.setComplement(updateUserDto.complement());
    updatedAddress.setNumber(Integer.parseInt(updateUserDto.number()));
    user.setAddress(updatedAddress);
    user.setEmail(updateUserDto.email());
    if (!updateUserDto.phones().isEmpty()) {
      updateUserDto.phones().forEach(user::setPhones);
    }
    if (user.passwordIsEmpty()) {
      user.setPassword(user.getName());
    }
    if (!updateUserDto.name().isEmpty()) {
      user.setName(updateUserDto.name());
    }
    return user;
  }

  public static Evaluation EvaluationUpdate(Evaluation evaluation, EvaluationUpdateDto updateDto) {
    if (!updateDto.url().isEmpty() && updateDto.sourceUserId().equals(evaluation.getSourceUserId())) {
      if (updateDto.url() != null) {
        evaluation.setUrl(updateDto.url());
      }
      if (updateDto.courseId() != null) {
        evaluation.setCourseId(updateDto.courseId());
      }
    }
    return evaluation;
  }
}
