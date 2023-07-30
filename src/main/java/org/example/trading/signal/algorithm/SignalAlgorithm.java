package org.example.trading.signal.algorithm;

import org.example.algo.Algo;

/**
 * Interface should be implemented by all signals
 * in order to be received and handled by the system.
 *
 * getHandledSignal() method returns code of the signal,
 * getAlgorithm() method returns appropriate algorithm.
 */
public interface SignalAlgorithm {

  int getSignal();

  Algo composeAlgorithm(Algo algo);
}
