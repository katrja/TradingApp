package org.example.trading.signal.algorithm;

import org.example.algo.Algo;
import org.springframework.stereotype.Component;

@Component
public class SignalAlgorithm3 implements SignalAlgorithm {

  @Override
  public int getSignal() {
    return 3;
  }

  @Override
  public Algo composeAlgorithm(Algo algo) {
    algo.setAlgoParam(1, 90);
    algo.setAlgoParam(2, 15);
    algo.performCalc();
    algo.submitToMarket();
    return algo;
  }
}
