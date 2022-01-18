package com.marcoscassiani.rockpaperscissorsgame.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    UUID id = UUID.randomUUID();

    @Test
    void getId() {
        Match match = new Match(id);
        assertEquals(match.getId(), id);
    }

    @Test
    void getRounds() {
        Match match = new Match(id);
        List<Round> rounds = new ArrayList<>();
        rounds.add(new Round(HandShape.PAPER, HandShape.ROCK, RoundResult.P1_WINS));
        rounds.add(new Round(HandShape.PAPER, HandShape.PAPER, RoundResult.DRAW));
        match.setRounds(rounds);

        assertEquals(match.getRounds().size(), rounds.size());
        assertEquals(match.getRounds().get(0).getResult(),RoundResult.P1_WINS);
        assertEquals(match.getRounds().get(1).getResult(),RoundResult.DRAW);
    }

    @Test
    void setId() {
        Match match = new Match(id);
        UUID newId = UUID.randomUUID();
        match.setId(newId);

        assertEquals(match.getId(), newId);
    }

    @Test
    void setRounds() {
        Match match = new Match(id);
        List<Round> rounds = new ArrayList<>();
        rounds.add(new Round(HandShape.PAPER, HandShape.ROCK, RoundResult.P1_WINS));
        rounds.add(new Round(HandShape.PAPER, HandShape.PAPER, RoundResult.DRAW));
        match.setRounds(rounds);
        assertEquals(match.getRounds().size(), rounds.size());
    }

}