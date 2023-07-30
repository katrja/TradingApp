package org.example.trading.signal.algorithm;

import org.example.algo.Algo;
import org.springframework.stereotype.Component;

@Component
public class DefaultSignalAlgorithm {
  public Algo composeAlgorithm(Algo algo) {
    algo.cancelTrades();
    return algo;
  }
}
