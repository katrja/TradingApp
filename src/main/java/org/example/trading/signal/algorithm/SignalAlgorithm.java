package org.example.trading.signal.algorithm;

import org.example.algo.Algo;

public interface SignalAlgorithm {

  int getHandledSignal();

  Algo getAlgorithm();
}
