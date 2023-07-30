package org.example.trading.signal;
import java.util.Map;
import org.example.algo.Algo;
import org.example.trading.signal.algorithm.DefaultSignalAlgorithm;
import org.example.trading.signal.algorithm.SignalAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Factory class to provide algorithms for handling known signals. In order to add a new signal
 * handling, extend signalHandlers collection. signalHandlers - collection that maps signal code to
 * SignalAlgorithm object that knows how to handle the signal.
 */
@Service
public class SignalAlgorithmFactory {

  private Map<Integer, SignalAlgorithm> signalAlgorithms;

  @Autowired
  private DefaultSignalAlgorithm defaultSignalAlgorithm;

  @Autowired
  public SignalAlgorithmFactory(Map<Integer, SignalAlgorithm> signalAlgorithms) {
    this.signalAlgorithms = signalAlgorithms;
  }

  /**
   * @param signal int
   * @return SignalAlgorithm - object that knows algorithm for the incoming signal. If system
   * doesn't know how to handle incoming code, default handler will be used (default code is 0).
   */
  public Algo createAlgorithm(Algo algo, int signal) {
    if (signalAlgorithms.containsKey(signal)) {
      return signalAlgorithms.get(signal).composeAlgorithm(algo);
    } else {
      return defaultSignalAlgorithm.composeAlgorithm(algo);
    }
  }
}
