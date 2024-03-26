package com.celin.sitecelin.entities.exceptions;

public class IllegalUserField extends RuntimeException{
  public IllegalUserField(String errorDetail) {
    super(errorDetail);
  }
}
