package org.example.trading.signal.algorithm;

import org.example.algo.Algo;

public class DefaultSignalAlgorithm implements SignalAlgorithm {

  Algo algo;

  public DefaultSignalAlgorithm() {
    this.algo = new Algo();
  }

  @Override
  public int getHandledSignal() {
    return 0;
  }

  @Override
  public Algo getAlgorithm() {
    algo.cancelTrades();
    return algo;
  }
}
