package org.example.trading;

import org.example.trading.controller.TradingApp;
import org.example.trading.service.SignalHandler;
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

  @Test
  public void contextLoads() throws Exception {
    assertThat(controller).isNotNull();
    assertThat(signalHandler).isNotNull();
  }
}