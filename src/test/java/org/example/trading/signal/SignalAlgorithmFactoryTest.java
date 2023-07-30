package org.example.trading.signal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.example.algo.Algo;
import org.example.trading.signal.algorithm.DefaultSignalAlgorithm;
import org.example.trading.signal.algorithm.SignalAlgorithm;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SignalAlgorithmFactoryTest {

  public static final int SIGNAL_CODE = 1;
  @Mock
  private DefaultSignalAlgorithm defaultSignalAlgorithm;
  @Mock
  Algo testAlgo;
  @Mock
  private SignalAlgorithm testSignalAlgorithm;
  @InjectMocks
  SignalAlgorithmFactory underTest;

  @BeforeEach
  public void init() {
    Map<Integer, SignalAlgorithm> signalAlgorithms = new HashMap<>();
    underTest = new SignalAlgorithmFactory(signalAlgorithms);
    MockitoAnnotations.openMocks(this);
    signalAlgorithms.put(SIGNAL_CODE, testSignalAlgorithm);
  }

  @Test
  void createAlgorithm_knownSignal() {
    when(testSignalAlgorithm.composeAlgorithm(testAlgo)).thenReturn(testAlgo);

    Algo result = underTest.createAlgorithm(testAlgo, SIGNAL_CODE);
    assertEquals(testAlgo, result);
    Mockito.verify(testSignalAlgorithm).composeAlgorithm(testAlgo);
    Mockito.verifyNoMoreInteractions(defaultSignalAlgorithm);
  }

  @Test
  void createAlgorithm_unknownSignal() {
    int signalCode = Integer.MAX_VALUE;
    when(defaultSignalAlgorithm.composeAlgorithm(testAlgo)).thenReturn(testAlgo);

    Algo result = underTest.createAlgorithm(testAlgo, signalCode);
    assertEquals(testAlgo, result);
    Mockito.verifyNoInteractions(testSignalAlgorithm);
    Mockito.verify(defaultSignalAlgorithm).composeAlgorithm(testAlgo);
  }
}
