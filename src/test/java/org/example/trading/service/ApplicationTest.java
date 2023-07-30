package org.example.trading.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.example.algo.Algo;
import org.example.trading.signal.SignalAlgorithmFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ApplicationTest {

  @Mock
  private SignalAlgorithmFactory factory;

  @Mock
  private Algo algo;

  @InjectMocks
  private Application underTest;

  @BeforeEach
  public void init() {
    underTest = new Application();
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testHandleSignal() {
    int anySignalCode = 1;
    when(factory.createAlgorithm(any(), anyInt())).thenReturn(algo);

    underTest.handleSignal(anySignalCode);
    Mockito.verify(factory).createAlgorithm(any(Algo.class), anyInt());
    Mockito.verify(algo).doAlgo();
  }
}
