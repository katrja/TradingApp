package org.example.trading.service;

import org.example.algo.Algo;
import org.example.trading.signal.SignalAlgorithmFactory;
import org.example.trading.signal.algorithm.SignalAlgorithm;

/**
 * This is your team’s code and should be changed as you see fit.
 */
public class Application implements SignalHandler {

  public void handleSignal(int signal) {

    SignalAlgorithmFactory factory = new SignalAlgorithmFactory();
    SignalAlgorithm algorithm = factory.getHandledSignal(signal);
    algorithm.getAlgorythm().doAlgo();

   // Algo algo = new Algo();

   /* switch (signal) {
      case 1:
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
        break;
      case 2:
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
        break;
      case 3:
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
        break;
      default:
        algo.cancelTrades();
        break;
    }
    algo.doAlgo();
*/

  }
}
