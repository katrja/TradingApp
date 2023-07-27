package org.example.trading.service;

import org.example.algo.Algo;
import org.example.trading.signal.SignalAlgorithmFactory;
import org.example.trading.signal.algorithm.SignalAlgorithm;
import org.springframework.stereotype.Service;

/**
 * This is your team’s code and should be changed as you see fit.
 */
@Service
public class Application implements SignalHandler {

  public void handleSignal(int signal) {
    SignalAlgorithmFactory factory = new SignalAlgorithmFactory();
    SignalAlgorithm algorithm = factory.getHandledSignal(signal);
    algorithm.getAlgorythm().doAlgo();
  }
}
