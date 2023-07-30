package org.example.trading.signal.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.example.algo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SignalAlgorithm1Test {

  @Mock
  Algo algo;

  @InjectMocks
  SignalAlgorithm underTest;

  @BeforeEach
  public void initMocks() {
    underTest = new SignalAlgorithm1();
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getSignal1() {
    assertEquals(underTest.getSignal(), 1);
  }

  @Test
  public void getAlgorithm1() {
    underTest.composeAlgorithm(algo);
    verify(algo).setUp();
    verify(algo).setAlgoParam(1, 60);
    verify(algo).performCalc();
    verify(algo).submitToMarket();
  }

}
