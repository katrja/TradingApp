package org.example.trading.signal.exception;

public class DuplicatedSignalAlgorithmException extends Throwable {

  public DuplicatedSignalAlgorithmException(int signal) {
    super("Duplicated algorithm for signal " + signal);
  }
}
