package com.marcoscassiani.rockpaperscissorsgame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.marcoscassiani.rockpaperscissorsgame.model.HandShape;
import com.marcoscassiani.rockpaperscissorsgame.model.RoundResult;
import com.marcoscassiani.rockpaperscissorsgame.util.RoundResolver;
import org.junit.jupiter.api.Test;

public class MatchResolverTest {

    @Test
    public void testResultsWhenChoosingRock() {
        assertEquals(RoundResolver.resolve(HandShape.ROCK, HandShape.ROCK).getResult(),    RoundResult.DRAW);
        assertEquals(RoundResolver.resolve(HandShape.ROCK, HandShape.PAPER).getResult(),   RoundResult.P2_WINS);
        assertEquals(RoundResolver.resolve(HandShape.ROCK, HandShape.SCISSOR).getResult(), RoundResult.P1_WINS);
    }

    @Test
    public void testResultsWhenChoosingPaper() {
        assertEquals(RoundResolver.resolve(HandShape.PAPER, HandShape.ROCK).getResult(),    RoundResult.P1_WINS);
        assertEquals(RoundResolver.resolve(HandShape.PAPER, HandShape.PAPER).getResult(),   RoundResult.DRAW);
        assertEquals(RoundResolver.resolve(HandShape.PAPER, HandShape.SCISSOR).getResult(), RoundResult.P2_WINS);
    }

    @Test
    public void testResultsWhenChoosingScissor() {
        assertEquals(RoundResolver.resolve(HandShape.SCISSOR, HandShape.ROCK).getResult(),    RoundResult.P2_WINS);
        assertEquals(RoundResolver.resolve(HandShape.SCISSOR, HandShape.PAPER).getResult(),   RoundResult.P1_WINS);
        assertEquals(RoundResolver.resolve(HandShape.SCISSOR, HandShape.SCISSOR).getResult(), RoundResult.DRAW);
    }

}
