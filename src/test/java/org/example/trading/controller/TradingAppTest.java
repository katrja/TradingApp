package org.example.trading.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import jakarta.websocket.SendHandler;
import org.example.trading.service.Application;
import org.example.trading.service.SignalHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TradingAppTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SignalHandler service;

  @Test
  public void handleKnownSignal() throws Exception {
    int incomingSignal = 1;
    doNothing().when(service).handleSignal(incomingSignal);
    this.mockMvc.perform(post("/signal")
            .contentType(MediaType.APPLICATION_JSON)
            .content(String.valueOf(incomingSignal)))
        .andDo(print())
        .andExpect(status().isOk());

    Mockito.verify(service).handleSignal(incomingSignal);
    Mockito.verifyNoMoreInteractions(service);
  }

  @Test
  public void handleUnKnownSignal() throws Exception {
    int incomingSignal = 10;
   doNothing().when(service).handleSignal(incomingSignal);
    this.mockMvc.perform(post("/signal")
            .contentType(MediaType.APPLICATION_JSON)
            .content(String.valueOf(incomingSignal)))
        .andDo(print())
        .andExpect(status().isOk());
    Mockito.verify(service).handleSignal(incomingSignal);
    Mockito.verifyNoMoreInteractions(service);
  }

  @Test
  public void handleRequestWithoutSignal() throws Exception {
    this.mockMvc.perform(post("/signal"))
        .andDo(print())
        .andExpect(status().isBadRequest());
    Mockito.verifyNoInteractions(service);
  }
}
