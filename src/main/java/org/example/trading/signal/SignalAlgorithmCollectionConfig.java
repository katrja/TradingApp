package org.example.trading.signal;

import java.util.HashMap;
import java.util.Map;
import org.example.trading.signal.algorithm.SignalAlgorithm;
import org.example.trading.signal.algorithm.SignalAlgorithm1;
import org.example.trading.signal.algorithm.SignalAlgorithm2;
import org.example.trading.signal.algorithm.SignalAlgorithm3;
import org.example.trading.signal.exception.DuplicatedSignalAlgorithmException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SignalAlgorithmCollectionConfig {
  private final Map<Integer, SignalAlgorithm> signalAlgorithms = new HashMap<>();

  @Bean
  public Map<Integer, SignalAlgorithm> getSignalAlgorithms()
      throws DuplicatedSignalAlgorithmException {
    addSignalAlgorithm(new SignalAlgorithm1());
    addSignalAlgorithm(new SignalAlgorithm2());
    addSignalAlgorithm(new SignalAlgorithm3());
    return signalAlgorithms;
  }

  private void addSignalAlgorithm(SignalAlgorithm newAlgorithm)
      throws DuplicatedSignalAlgorithmException {
    if (signalAlgorithms.containsKey(newAlgorithm.getSignal())) {
      throw new DuplicatedSignalAlgorithmException(newAlgorithm.getSignal());
    }
    signalAlgorithms.put(newAlgorithm.getSignal(), newAlgorithm);
  }
}
