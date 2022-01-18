package com.marcoscassiani.rockpaperscissorsgame.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcoscassiani.rockpaperscissorsgame.model.MatchStats;
import com.marcoscassiani.rockpaperscissorsgame.service.MatchStatsService;
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

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@WebMvcTest(value=MatchStatsController.class)
class MatchStatsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MatchStatsService matchStatsService;

    @Test
    void get() throws Exception {

        MatchStats matchStats = new MatchStats();
        matchStats.setTotalRounds(10);
        matchStats.setTotalWinsP1(3);
        matchStats.setTotalWinsP2(4);
        matchStats.setTotalDraws(3);

        String URI = "/matches-stats";

        Mockito.when(matchStatsService.get()).thenReturn(matchStats);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();
        MatchStats matchStatsResult = new ObjectMapper().readValue(outputInJson, MatchStats.class);

        assertNotNull(response.getContentAsString());
        assertEquals(matchStatsResult.getTotalRounds(), 10);
        assertEquals(matchStatsResult.getTotalWinsP1(), 3);
        assertEquals(matchStatsResult.getTotalWinsP2(), 4);
        assertEquals(matchStatsResult.getTotalDraws(), 3);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}