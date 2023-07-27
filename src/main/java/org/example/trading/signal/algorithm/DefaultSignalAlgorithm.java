package org.example.trading.signal.algorithm;

import org.example.algo.Algo;

public class DefaultSignalAlgorithm implements SignalAlgorithm {

  @Override
  public int getHandledSignal() {
    return 0;
  }

  @Override
  public Algo getAlgorythm() {
    Algo algo = new Algo();
    algo.cancelTrades();
    return algo;
  }
}
