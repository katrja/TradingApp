package org.example.trading.signal.algorithm;

import org.example.algo.Algo;
import org.example.trading.signal.algorithm.SignalAlgorithm;

public class SignalAlgorithm1 implements SignalAlgorithm {

  Algo algo;

  public SignalAlgorithm1() {
    this.algo = new Algo();
  }

  @Override
  public int getHandledSignal() {
    return 1;
  }

  @Override
  public Algo getAlgorithm() {
    algo.setUp();
    algo.setAlgoParam(1, 60);
    algo.performCalc();
    algo.submitToMarket();
    return algo;
  }
}
