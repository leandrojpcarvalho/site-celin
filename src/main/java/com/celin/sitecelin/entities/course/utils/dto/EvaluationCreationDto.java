package com.celin.sitecelin.entities.course.utils.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record EvaluationCreationDto(
      @JsonProperty("userId")Long sourceUserId,
      @JsonProperty("url") String url
      ) {

}
