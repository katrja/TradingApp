package org.example.trading.signal.algorithm;

import org.example.algo.Algo;

public class SignalAlgorithm2 implements SignalAlgorithm {
  Algo algo;

  public SignalAlgorithm2() {
    this.algo = new Algo();
  }
  @Override
  public int getHandledSignal() {
    return 2;
  }

  @Override
  public Algo getAlgorithm() {
    algo.reverse();
    algo.setAlgoParam(1, 80);
    algo.submitToMarket();
    return algo;
  }
}
