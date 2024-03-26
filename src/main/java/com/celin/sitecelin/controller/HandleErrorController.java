package com.celin.sitecelin.controller;

import com.celin.sitecelin.entities.exceptions.IllegalServiceException;
import com.celin.sitecelin.entities.exceptions.IllegalUserField;
import org.springframework.boot.autoconfigure.data.RepositoryType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleErrorController {
  @ExceptionHandler({
        IllegalUserField.class
  })
  public ResponseEntity<String> userFields(IllegalUserField exception) {
    return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .body(exception.getMessage());
  }
@ExceptionHandler({
      IllegalServiceException.class
})
  public ResponseEntity<String> serviceException(IllegalServiceException exception) {
    return ResponseEntity
          .status(exception.getStatus())
          .body(exception.message());
  }
}
