package com.celin.sitecelin.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public record UpdateForm(
      @JsonProperty("cep") String zipCode,
      @JsonProperty("number") String number,
      @JsonProperty("complement") String complement,
      @JsonProperty("phones") ArrayList<String> phones,
      @JsonProperty("email") String email
){
}
