package org.example.trading.signal.algorithm;

import org.example.algo.Algo;

public class SignalAlgorithm3 implements SignalAlgorithm {

  Algo algo;

  public SignalAlgorithm3() {
    this.algo = new Algo();
  }

  @Override
  public int getHandledSignal() {
    return 3;
  }

  @Override
  public Algo getAlgorithm() {
    algo.setAlgoParam(1, 90);
    algo.setAlgoParam(2, 15);
    algo.performCalc();
    algo.submitToMarket();
    return algo;
  }
}
