package org.example.trading.signal;

import java.util.HashMap;
import java.util.Map;
import org.example.trading.signal.algorithm.DefaultSignalAlgorithm;
import org.example.trading.signal.algorithm.SignalAlgorithm;
import org.example.trading.signal.algorithm.SignalAlgorithm1;
import org.example.trading.signal.algorithm.SignalAlgorithm2;
import org.example.trading.signal.algorithm.SignalAlgorithm3;

/**
 * Factory class to provide algorithms for handling known signals.
 * In order to add a new signal handling, extend signalHandlers collection.
 *
 * signalHandlers - collection that maps signal code to SignalAlgorithm object that
 * knows how to handle the signal.
 *
 */
public class SignalAlgorithmFactory {

  private final static Map<Integer, SignalAlgorithm> signalHandlers = new HashMap();

  public SignalAlgorithmFactory() {
    SignalAlgorithm sa1 = new SignalAlgorithm1();
    signalHandlers.put(sa1.getHandledSignal(), sa1);

    SignalAlgorithm sa2 = new SignalAlgorithm2();
    signalHandlers.put(sa2.getHandledSignal(), sa2);

    SignalAlgorithm sa3 = new SignalAlgorithm3();
    signalHandlers.put(sa3.getHandledSignal(), sa3);

    SignalAlgorithm saDefault = new DefaultSignalAlgorithm();
    signalHandlers.put(saDefault.getHandledSignal(), saDefault);
  }

  /**
   * @param signal int
   * @return SignalAlgorithm - object that knows algorithm for the incoming signal.
   * If system doesn't know how to handle incoming code, default handler will be used
   * (default code is 0).
   */
  public SignalAlgorithm getHandledSignal(int signal) {
    if (signalHandlers.containsKey(signal)) {
      return signalHandlers.get(signal);
    } else {
      return signalHandlers.get(0);
    }
  }
}
