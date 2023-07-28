package org.example.trading.signal.algorithm;

import org.example.algo.Algo;

public class SignalAlgorithm3 implements SignalAlgorithm {

  @Override
  public int getHandledSignal() {
    return 3;
  }

  @Override
  public Algo getAlgorithm() {
    Algo algo = new Algo();
    algo.setAlgoParam(1, 90);
    algo.setAlgoParam(2, 15);
    algo.performCalc();
    algo.submitToMarket();
    return algo;
  }
}
