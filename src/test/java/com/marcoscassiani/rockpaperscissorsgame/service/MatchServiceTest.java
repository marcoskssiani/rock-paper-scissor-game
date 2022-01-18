package com.marcoscassiani.rockpaperscissorsgame.service;

import com.marcoscassiani.rockpaperscissorsgame.model.HandShape;
import com.marcoscassiani.rockpaperscissorsgame.model.Match;
import com.marcoscassiani.rockpaperscissorsgame.model.Round;
import com.marcoscassiani.rockpaperscissorsgame.repository.MatchRepository;
import com.marcoscassiani.rockpaperscissorsgame.util.RoundResolver;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MatchServiceTest {

    @Autowired
    private MatchService matchService;

    @MockBean
    private MatchRepository matchRepository;

    @Test
    void create() {
        Match match = new Match(UUID.randomUUID());

        Mockito.when(matchRepository.save(Mockito.any(Match.class))).thenReturn(match);
        Assertions.assertThat(matchService.create()).isEqualTo(match);
    }

    @Test
    void get() {
        UUID matchId = UUID.randomUUID();
        Match match = new Match();

        Mockito.when(matchRepository.get(Mockito.any(UUID.class))).thenReturn(match);
        Assertions.assertThat(matchService.get(matchId)).isEqualTo(match);
    }

    @Test
    void getAll() {
        UUID matchId  = UUID.randomUUID();
        UUID matchId2 = UUID.randomUUID();

        Match match1 = new Match(matchId);
        Match match2 = new Match(matchId2);

        Map<UUID, Match> matches = new HashMap<>();
        matches.put(matchId,  match1);
        matches.put(matchId2, match2);

        Mockito.when(matchRepository.getAll()).thenReturn(matches);
        Assertions.assertThat(matchService.getAll()).size().isEqualTo(2);
    }

    @Test
    void addRound() {
        UUID matchId = UUID.randomUUID();
        Match match = new Match(matchId);
        Round round = RoundResolver.resolve(HandShape.PAPER, HandShape.ROCK);
        round.setMatchId(matchId);

        List<Round> rounds = new ArrayList<>();
        rounds.add(round);

        match.setRounds(rounds);

        Mockito.when(matchRepository.get(Mockito.any(UUID.class))).thenReturn(match);
        Mockito.when(matchRepository.update(match)).thenReturn(match);

        Assertions.assertThat(matchService.addRound(round)).isEqualTo(match);
    }
}