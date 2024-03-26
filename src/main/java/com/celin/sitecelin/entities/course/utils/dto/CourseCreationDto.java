package com.celin.sitecelin.entities.course.utils.dto;

import com.celin.sitecelin.entities.course.utils.Evaluation;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CourseCreationDto (
      @JsonProperty("schoolDays") int schoolDays,
      @JsonProperty("name") String name,
      @JsonProperty("courseDescription") String courseDescription
      ) {
}
