package com.marcoscassiani.rockpaperscissorsgame.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcoscassiani.rockpaperscissorsgame.model.HandShape;
import com.marcoscassiani.rockpaperscissorsgame.model.Match;
import com.marcoscassiani.rockpaperscissorsgame.model.Round;
import com.marcoscassiani.rockpaperscissorsgame.model.RoundResult;
import com.marcoscassiani.rockpaperscissorsgame.service.MatchService;
import com.marcoscassiani.rockpaperscissorsgame.service.RoundService;
import com.marcoscassiani.rockpaperscissorsgame.util.RoundResolver;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value=RoundController.class)
class RoundControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MatchService matchService;

    @MockBean
    private RoundService roundService;

    @Test
    void playRound() throws Exception {
        UUID matchId = UUID.randomUUID();
        Match match = new Match(matchId);
        Round round = RoundResolver.resolve(HandShape.PAPER, HandShape.ROCK);
        round.setMatchId(matchId);

        String URI = "/matches/" + matchId + "/rounds";

        Mockito.when(roundService.playRound(matchId)).thenReturn(round);
        Mockito.when(matchService.addRound(round)).thenReturn(match);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();
        Round roundResult = new ObjectMapper().readValue(outputInJson, Round.class);

        assertNotNull(response.getContentAsString());
        assertNotNull(roundResult.getMatchId());
        assertEquals(roundResult.getPlayer1Shape(), HandShape.PAPER);
        assertEquals(roundResult.getPlayer2Shape(), HandShape.ROCK);
        assertEquals(roundResult.getResult(), RoundResult.P1_WINS);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}