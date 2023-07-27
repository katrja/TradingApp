package org.example.trading.signal;

import java.util.HashMap;
import java.util.Map;
import org.example.trading.signal.algorithm.SignalAlgorithm;
import org.example.trading.signal.algorithm.SignalAlgorithm1;

public class SignalAlgorithmFactory {

  private final static Map<Integer, SignalAlgorithm> signalHandlers = new HashMap();
  static {
    SignalAlgorithm sa1 = new SignalAlgorithm1();
    signalHandlers.put(sa1.getHandledSignal(), sa1);
    //TODO: add for another signals

  };

   public SignalAlgorithm getHandledSignal(int signal) {
    return  signalHandlers.get(signal);
  }

}
