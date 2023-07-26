package org.example.trading.controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TradingApp extends HttpServlet {

  /**
   * POST endpoint to receive signal
   */
  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    try {
      Integer signal = (Integer) request.getAttribute("signal");
      receiveSignal(signal);

    } catch (NullPointerException ex) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Signal parameter should be integer");
    }
}

  /**
   * Handle incoming signal
   * @param signal Integer
   */
  private void receiveSignal(Integer signal) {
   //TODO
  }
}
