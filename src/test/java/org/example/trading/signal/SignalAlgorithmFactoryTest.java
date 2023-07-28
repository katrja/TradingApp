package org.example.trading.signal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.trading.signal.algorithm.DefaultSignalAlgorithm;
import org.example.trading.signal.algorithm.SignalAlgorithm;
import org.example.trading.signal.algorithm.SignalAlgorithm1;
import org.example.trading.signal.algorithm.SignalAlgorithm2;
import org.example.trading.signal.algorithm.SignalAlgorithm3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SignalAlgorithmFactoryTest {

  SignalAlgorithmFactory underTest;

  @BeforeEach
  public void init(){
    underTest = new SignalAlgorithmFactory();
  }

  @Test
  void getHandledSignal_signal1(){
    int signalCode = 1;
    SignalAlgorithm result = underTest.getHandledSignal(signalCode);
    assertEquals(result.getClass(), SignalAlgorithm1.class);
  }

  @Test
  void getHandledSignal_signal2(){
    int signalCode = 2;
    SignalAlgorithm result = underTest.getHandledSignal(signalCode);
    assertEquals(result.getClass(), SignalAlgorithm2.class);
  }

  @Test
  void getHandledSignal_signal3(){
    int signalCode = 3;
    SignalAlgorithm result = underTest.getHandledSignal(signalCode);
    assertEquals(result.getClass(), SignalAlgorithm3.class);
  }

  @Test
  void getHandledSignal_defaultSignal(){
    int signalCode = 10;
    SignalAlgorithm result = underTest.getHandledSignal(signalCode);
    assertEquals(result.getClass(), DefaultSignalAlgorithm.class);
  }
}
