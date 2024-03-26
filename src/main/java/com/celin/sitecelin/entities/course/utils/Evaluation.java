package com.celin.sitecelin.entities.course.utils;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class Evaluation {
  private final Long id;
  private Long courseId;
  private Long sourceUserId;
  private final Date creation;
  private Date update;
  private String url;

  public Evaluation(Long id) {
    this.id = id;
    this.creation = Date.from(Instant.now());
    this.update = this.creation;
  }

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    setUpdate();
    this.courseId = courseId;
  }

  public Date getCreation() {
    return creation;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    setUpdate();
    this.url = url;
  }

  public Date getUpdate() {
    return update;
  }

  private void setUpdate() {
    this.update = Date.from(Instant.now());
  }

  public Long getSourceUserId() {
    return sourceUserId;
  }

  public void setSourceUserId(Long sourceUserId) {
    this.sourceUserId = sourceUserId;
  }

  public Long getId() {
    return id;
  }
}
