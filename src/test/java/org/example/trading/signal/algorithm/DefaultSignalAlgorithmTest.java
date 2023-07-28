package org.example.trading.signal.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.example.algo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DefaultSignalAlgorithmTest {

  @Mock
  Algo algo;

  @InjectMocks
  SignalAlgorithm underTest;

  @BeforeEach
  public void initMocks() {
    underTest = new DefaultSignalAlgorithm();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getDefaultSignal() {
    assertEquals(underTest.getHandledSignal(), 0);
  }

  @Test
  public void getDefaultAlgorithm() {
    underTest.getAlgorithm();
    verify(algo).cancelTrades();
  }
}
