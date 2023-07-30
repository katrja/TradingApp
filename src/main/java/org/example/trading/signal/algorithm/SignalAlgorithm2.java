package org.example.trading.signal.algorithm;

import org.example.algo.Algo;
import org.springframework.stereotype.Component;

@Component
public class SignalAlgorithm2 implements SignalAlgorithm {

  @Override
  public int getSignal() {
    return 2;
  }

  @Override
  public Algo composeAlgorithm(Algo algo) {
    algo.reverse();
    algo.setAlgoParam(1, 80);
    algo.submitToMarket();
    return algo;
  }
}
