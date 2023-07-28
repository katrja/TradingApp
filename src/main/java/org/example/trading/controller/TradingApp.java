package org.example.trading.controller;

import org.example.trading.service.Application;
import org.example.trading.service.SignalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradingApp {

  @Autowired
  SignalHandler signalHandler;
	
  /**
   * POST endpoint to receive and handle signals.
   *
   * Known incoming signal will be handled and 200 status code returned.
   * If HTTP request contains no signal code, 400 status code will be returned.
   * If unknown signal code comes in HTTP request, system proceeds with default handler.
   */
  @PostMapping("/signal")
  protected void receiveSignal(@RequestBody Integer signal) {
    signalHandler.handleSignal(signal);
  }
}
