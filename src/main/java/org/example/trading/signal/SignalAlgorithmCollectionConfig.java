package org.example.trading.signal;

import java.util.HashMap;
import java.util.Map;
import org.example.trading.signal.algorithm.SignalAlgorithm;
import org.example.trading.signal.algorithm.SignalAlgorithm1;
import org.example.trading.signal.algorithm.SignalAlgorithm2;
import org.example.trading.signal.algorithm.SignalAlgorithm3;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SignalAlgorithmCollectionConfig {

  @Bean
  public Map<Integer, SignalAlgorithm> getSignalAlgorithms() {
    Map<Integer, SignalAlgorithm> signalAlgorithms = new HashMap<>();

    SignalAlgorithm sa1 = new SignalAlgorithm1();
    signalAlgorithms.put(sa1.getSignal(), sa1);

    SignalAlgorithm sa2 = new SignalAlgorithm2();
    signalAlgorithms.put(sa2.getSignal(), sa2);

    SignalAlgorithm sa3 = new SignalAlgorithm3();
    signalAlgorithms.put(sa3.getSignal(), sa3);
    return signalAlgorithms;
  }

}
