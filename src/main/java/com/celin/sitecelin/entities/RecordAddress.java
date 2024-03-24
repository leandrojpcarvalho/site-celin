package com.celin.sitecelin.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RecordAddress(
      @JsonProperty("logradouro") String address,
      @JsonProperty("cep") String ZIP,

      @JsonProperty("localidade") String city,
      @JsonProperty("uf") String state
) {
}
