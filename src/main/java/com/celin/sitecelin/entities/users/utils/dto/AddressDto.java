package com.celin.sitecelin.entities.users.utils.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressDto(
      @JsonProperty("logradouro") String address,
      @JsonProperty("cep") String ZIP,
      @JsonProperty("localidade") String city,
      @JsonProperty("uf") String state
) {
}
