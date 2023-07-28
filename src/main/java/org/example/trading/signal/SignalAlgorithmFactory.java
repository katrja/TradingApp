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
 * For handling new signal, add new item in signalHandlers collection.
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

    SignalAlgorithm saDeafult = new DefaultSignalAlgorithm();
    signalHandlers.put(saDeafult.getHandledSignal(), saDeafult);
  }

  public SignalAlgorithm getHandledSignal(int signal) {
    return signalHandlers.get(signal);
  }
}
