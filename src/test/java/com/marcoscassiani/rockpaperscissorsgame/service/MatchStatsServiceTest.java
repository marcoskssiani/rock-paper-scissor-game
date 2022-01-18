package com.marcoscassiani.rockpaperscissorsgame.service;

import com.marcoscassiani.rockpaperscissorsgame.model.HandShape;
import com.marcoscassiani.rockpaperscissorsgame.model.Match;
import com.marcoscassiani.rockpaperscissorsgame.model.MatchStats;
import com.marcoscassiani.rockpaperscissorsgame.model.RoundResult;
import com.marcoscassiani.rockpaperscissorsgame.util.RoundResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class MatchStatsServiceTest {

    @MockBean
    MatchService matchService;

    Map<UUID, Match> matches = new HashMap<>();

    @BeforeEach
    void setUp() {

        Match match = new Match(UUID.randomUUID());
        match.getRounds().add(RoundResolver.resolve(HandShape.ROCK      , HandShape.ROCK));
        match.getRounds().add(RoundResolver.resolve(HandShape.PAPER     , HandShape.ROCK));
        match.getRounds().add(RoundResolver.resolve(HandShape.SCISSOR   , HandShape.ROCK));

        Match match1 = new Match(UUID.randomUUID());
        match1.getRounds().add(RoundResolver.resolve(HandShape.ROCK     , HandShape.PAPER));
        match1.getRounds().add(RoundResolver.resolve(HandShape.PAPER    , HandShape.PAPER));
        match1.getRounds().add(RoundResolver.resolve(HandShape.SCISSOR  , HandShape.PAPER));

        Match match2 = new Match(UUID.randomUUID());
        match2.getRounds().add(RoundResolver.resolve(HandShape.ROCK     , HandShape.SCISSOR));
        match2.getRounds().add(RoundResolver.resolve(HandShape.PAPER    , HandShape.SCISSOR));
        match2.getRounds().add(RoundResolver.resolve(HandShape.SCISSOR  , HandShape.SCISSOR));
        match2.getRounds().add(RoundResolver.resolve(HandShape.ROCK     , HandShape.PAPER));

        matches.put(match.getId() , match);
        matches.put(match1.getId(), match1);
        matches.put(match2.getId(), match2);
    }

    @Test
    void get() {
        matchService = Mockito.mock(MatchService.class);
        Mockito.when(matchService.getAll()).thenReturn(matches);

        MatchStatsService matchStatsService = new MatchStatsService(matchService);
        MatchStats matchStats = matchStatsService.get();

        Assertions.assertEquals(matchStats.getTotalRounds(), 10);
        Assertions.assertEquals(matchStats.getTotalWinsP1(), 3);
        Assertions.assertEquals(matchStats.getTotalWinsP2(), 4);
        Assertions.assertEquals(matchStats.getTotalDraws() , 3);
    }

    @Test
    void getTotalRounds() {

        matchService = Mockito.mock(MatchService.class);
        Mockito.when(matchService.getAll()).thenReturn(matches);

        MatchStatsService matchStatsService = new MatchStatsService(matchService);
        Assertions.assertEquals(matchStatsService.getTotalRounds(), 10);
    }

    @Test
    void getTotalWins() {
        matchService = Mockito.mock(MatchService.class);
        Mockito.when(matchService.getAll()).thenReturn(matches);

        MatchStatsService matchStatsService = new MatchStatsService(matchService);
        Assertions.assertEquals(matchStatsService.getTotalWins(RoundResult.P1_WINS) , 3);
        Assertions.assertEquals(matchStatsService.getTotalWins(RoundResult.P2_WINS) , 4);
        Assertions.assertEquals(matchStatsService.getTotalWins(RoundResult.DRAW)    , 3);
    }
}