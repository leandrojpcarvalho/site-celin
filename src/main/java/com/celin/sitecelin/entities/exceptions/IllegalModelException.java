package com.celin.sitecelin.entities.exceptions;

public class IllegalModelException extends RuntimeException{
  public IllegalModelException(String errorDescription) {
    super(errorDescription);
  }
}
