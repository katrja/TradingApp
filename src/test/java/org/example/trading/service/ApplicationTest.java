package org.example.trading.service;

import static org.mockito.Mockito.when;

import org.example.algo.Algo;
import org.example.trading.signal.SignalAlgorithmFactory;
import org.example.trading.signal.algorithm.SignalAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ApplicationTest {

  @Mock
  SignalAlgorithmFactory asFactory;

  @Mock
  SignalAlgorithm signalAlgorithm;

  @Mock
  Algo algo;

  @InjectMocks
  Application underTest = new Application();

  @BeforeEach
  void initMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testHandleSignal() {
    int signalCode = 1;
    when(asFactory.getHandledSignal(signalCode)).thenReturn(signalAlgorithm);
    when(signalAlgorithm.getAlgorithm()).thenReturn(algo);

    underTest.handleSignal(signalCode);
    Mockito.verify(asFactory).getHandledSignal(signalCode);
    Mockito.verify(signalAlgorithm).getAlgorithm();
    Mockito.verify(algo).doAlgo();
  }
}
