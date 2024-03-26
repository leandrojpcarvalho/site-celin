package com.celin.sitecelin.entities.users.utils.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public record AvailabilityDto(
      @JsonProperty("days") HashMap<String, String[]> days
) {
}