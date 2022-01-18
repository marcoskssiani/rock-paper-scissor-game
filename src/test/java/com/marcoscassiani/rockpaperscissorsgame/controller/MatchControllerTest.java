package com.marcoscassiani.rockpaperscissorsgame.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcoscassiani.rockpaperscissorsgame.model.Match;
import com.marcoscassiani.rockpaperscissorsgame.service.MatchService;
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

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@WebMvcTest(value=MatchController.class)
class MatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MatchService matchService;

    @Test
    void create() throws Exception {
        Match match = new Match(UUID.randomUUID());

        String URI = "/matches";

        Mockito.when(matchService.create()).thenReturn(match);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();
        Match matchResut = new ObjectMapper().readValue(outputInJson, Match.class);

        assertNotNull(response.getContentAsString());
        assertNotNull(matchResut.getId());
        assertTrue(matchResut.getRounds().isEmpty());
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void get() throws Exception {
        UUID matchId = UUID.randomUUID();
        Match match = new Match(matchId);

        String URI = "/matches/" + matchId;

        Mockito.when(matchService.get(matchId)).thenReturn(match);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();
        Match matchResult = new ObjectMapper().readValue(outputInJson, Match.class);

        assertNotNull(response.getContentAsString());
        assertNotNull(matchResult.getId());
        assertTrue(matchResult.getRounds().isEmpty());
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void getAll() throws Exception {
        UUID matchId  = UUID.randomUUID();
        UUID matchId2 = UUID.randomUUID();

        Match match1 = new Match(matchId);
        Match match2 = new Match(matchId2);

        Map<UUID, Match> matches = new HashMap<>();
        matches.put(matchId,  match1);
        matches.put(matchId2, match2);

        String URI = "/matches/";

        Mockito.when(matchService.getAll()).thenReturn(matches);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();
            HashMap<UUID, Match> matchesResult = new ObjectMapper().readValue(outputInJson, HashMap.class);

        assertNotNull(response.getContentAsString());
        assertNotNull(matchesResult);
        assertTrue(matchesResult.size() == 2);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}