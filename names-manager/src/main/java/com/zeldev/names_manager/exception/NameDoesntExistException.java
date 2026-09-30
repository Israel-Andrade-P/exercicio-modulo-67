package com.zeldev.names_manager.exception;

public class NameDoesntExistException extends RuntimeException {
  public NameDoesntExistException(String message) {
    super(message);
  }
}
