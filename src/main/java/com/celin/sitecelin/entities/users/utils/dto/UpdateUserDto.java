package com.celin.sitecelin.entities.users.utils.dto;

import com.celin.sitecelin.entities.users.utils.Phone;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public record UpdateUserDto(
      @JsonProperty("cep") String zipCode,
      @JsonProperty("number") String number,
      @JsonProperty("complement") String complement,
      @JsonProperty("phones") ArrayList<String> phones,
      @JsonProperty("email") String email,
      @JsonProperty("name") String name
){
}
