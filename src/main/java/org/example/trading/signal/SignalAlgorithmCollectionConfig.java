package org.example.trading.signal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
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
  public Map<Integer, SignalAlgorithm> getSignalAlgorithms(List<SignalAlgorithm> signals)
      throws DuplicatedSignalAlgorithmException {
    return signals.stream().collect(Collectors.toMap(SignalAlgorithm::getSignal, Function.identity()));
  }

  private void addSignalAlgorithm(SignalAlgorithm newAlgorithm)
      throws DuplicatedSignalAlgorithmException {
    if (signalAlgorithms.containsKey(newAlgorithm.getSignal())) {
      throw new DuplicatedSignalAlgorithmException(newAlgorithm.getSignal());
    }
    signalAlgorithms.put(newAlgorithm.getSignal(), newAlgorithm);
  }
}
