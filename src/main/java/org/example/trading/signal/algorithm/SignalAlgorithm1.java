package org.example.trading.signal.algorithm;

import org.example.algo.Algo;
import org.example.trading.signal.algorithm.SignalAlgorithm;

public class SignalAlgorithm1 implements SignalAlgorithm {

  @Override
  public int getHandledSignal() {
    return 1;
  }

  @Override
  public Algo getAlgorithm() {
    Algo algo = new Algo();
    algo.setUp();
    algo.setAlgoParam(1, 60);
    algo.performCalc();
    algo.submitToMarket();
    return algo;
  }
}
