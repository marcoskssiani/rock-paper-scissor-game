package com.marcoscassiani.rockpaperscissorsgame.repository;

import com.marcoscassiani.rockpaperscissorsgame.model.HandShape;
import com.marcoscassiani.rockpaperscissorsgame.model.Match;
import com.marcoscassiani.rockpaperscissorsgame.model.Round;
import com.marcoscassiani.rockpaperscissorsgame.model.RoundResult;
import com.marcoscassiani.rockpaperscissorsgame.util.RoundResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class MatchRepositoryTest {

    MatchRepository repository;
    Match match;

    @BeforeEach
    void setUp() {
        repository = new MatchRepository();
        match = new Match(UUID.randomUUID());
    }

    @Test
    void save() {
        Round round = RoundResolver.resolve(HandShape.PAPER, HandShape.ROCK);
        repository.save(match);
        assertTrue(repository.get(match.getId()).getRounds().isEmpty());
    }

    @Test
    void update() {
        repository.save(match);
        assertTrue(repository.get(match.getId()).getRounds().isEmpty());

        List<Round> rounds = new ArrayList<>();
        rounds.add(new Round(HandShape.PAPER, HandShape.ROCK, RoundResult.P1_WINS));
        rounds.add(new Round(HandShape.PAPER, HandShape.PAPER, RoundResult.DRAW));
        match.setRounds(rounds);

        repository.update(match);
        assertEquals(repository.get(match.getId()).getRounds().size(), 2);
    }

    @Test
    void get() {
        repository.save(match);
        assertTrue(repository.get(match.getId()).getRounds().isEmpty());
    }

    @Test
    void getAll() {
        repository.save(match);
        repository.save(new Match(UUID.randomUUID()));

        assertEquals(repository.getAll().size(), 2);
    }
}