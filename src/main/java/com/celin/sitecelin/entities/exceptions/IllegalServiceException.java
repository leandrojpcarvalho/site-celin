package com.celin.sitecelin.entities.exceptions;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;

public class IllegalServiceException extends RuntimeException {
  private final HttpStatus status;
  public IllegalServiceException(String errorDetail, HttpStatus status) {
    super(errorDetail);
    this.status = status;
  }

  public String message() {
    return "{ message: " + getMessage() + "}" ;
  }
  public HttpStatus getStatus() {
    return status;
  }
}
