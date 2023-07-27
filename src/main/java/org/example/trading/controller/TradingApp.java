package org.example.trading.controller;

import org.example.trading.service.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradingApp {

  @Autowired
  Application tragingApplication;
	
  /**
   * POST endpoint to receive signal
   */
  @PostMapping("/signal")
  protected void receiveSignal(@RequestBody Integer signal) {

    tragingApplication.handleSignal(signal);

}
}
