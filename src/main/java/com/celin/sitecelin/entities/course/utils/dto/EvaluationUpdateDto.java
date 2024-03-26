package com.celin.sitecelin.entities.course.utils.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EvaluationUpdateDto(
      @JsonProperty("userId") Long sourceUserId,
      @JsonProperty("evaluationId") Long id,
      @JsonProperty("courseId") Long courseId,
      @JsonProperty("url") String url
) {
}
