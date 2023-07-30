package org.example.trading.service;

import org.example.algo.Algo;
import org.example.algo.SignalHandler;
import org.example.trading.signal.SignalAlgorithmFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is your team’s code and should be changed as you see fit.
 */
@Service
public class Application implements SignalHandler {

  @Autowired
  private SignalAlgorithmFactory factory;

  /**
   * Main method that should be called when new signal received.
   * Based on the signal code, matching handling algorithm will be called.
   * @param signal int - signal code.
   */
  public void handleSignal(int signal) {
    Algo algo = new Algo();
    factory.createAlgorithm(algo, signal).doAlgo();
  }
}
