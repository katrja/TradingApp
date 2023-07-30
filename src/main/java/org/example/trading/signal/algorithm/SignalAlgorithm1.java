package org.example.trading.signal.algorithm;

import org.example.algo.Algo;
import org.springframework.stereotype.Component;

@Component
public class SignalAlgorithm1 implements SignalAlgorithm {

  @Override
  public int getSignal() {
    return 1;
  }

  @Override
  public Algo composeAlgorithm(Algo algo) {
    algo.setUp();
    algo.setAlgoParam(1, 60);
    algo.performCalc();
    algo.submitToMarket();
    return algo;
  }
}
