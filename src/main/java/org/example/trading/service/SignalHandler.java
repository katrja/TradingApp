package org.example.trading.service;

/**
 * This is an upcall from our trading system, and we cannot change it.
 */
public interface SignalHandler {

  void handleSignal(int signal);
}
