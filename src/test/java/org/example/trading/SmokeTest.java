package org.example.trading;

import java.util.Map;
import org.example.trading.controller.TradingApp;
import org.example.algo.SignalHandler;
import org.example.trading.signal.SignalAlgorithmFactory;
import org.example.trading.signal.algorithm.DefaultSignalAlgorithm;
import org.example.trading.signal.algorithm.SignalAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

  @Autowired
  private TradingApp controller;

  @Autowired
  private SignalHandler signalHandler;

  @Autowired
  private SignalAlgorithmFactory factory;

  @Autowired
  private DefaultSignalAlgorithm defaultSignalAlgorithm;

  @Autowired
  public Map<Integer, SignalAlgorithm> getSignalAlgorithms;

    @Test
  public void contextLoads() throws Exception {
    assertThat(controller).isNotNull();
    assertThat(signalHandler).isNotNull();
    assertThat(factory).isNotNull();
    assertThat(defaultSignalAlgorithm).isNotNull();
    assertThat(getSignalAlgorithms).isNotNull();
  }
}