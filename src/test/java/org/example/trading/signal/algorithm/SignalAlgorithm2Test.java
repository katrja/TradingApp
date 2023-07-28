package org.example.trading.signal.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.example.algo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SignalAlgorithm2Test {

  @Mock
  Algo algo;

  @InjectMocks
  SignalAlgorithm underTest;

  @BeforeEach
  public void initMocks() {
    underTest = new SignalAlgorithm2();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getSignal2() {
    assertEquals(underTest.getHandledSignal(), 2);
  }

  @Test
  public void getAlgorithm2() {
    underTest.getAlgorithm();
    verify(algo).reverse();
    verify(algo).setAlgoParam(1, 80);
    verify(algo).submitToMarket();
  }

}
