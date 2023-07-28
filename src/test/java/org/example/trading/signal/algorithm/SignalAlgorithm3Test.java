package org.example.trading.signal.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.example.algo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SignalAlgorithm3Test {

  @Mock
  Algo algo;

  @InjectMocks
  SignalAlgorithm underTest;

  @BeforeEach
  public void initMocks() {
    underTest = new SignalAlgorithm3();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getSignal3() {
    assertEquals(underTest.getHandledSignal(), 3);
  }

  @Test
  public void getAlgorithm3() {
    underTest.getAlgorithm();
    verify(algo).setAlgoParam(1, 90);
    verify(algo).setAlgoParam(2, 15);
    verify(algo).performCalc();
    verify(algo).submitToMarket();
  }

}
