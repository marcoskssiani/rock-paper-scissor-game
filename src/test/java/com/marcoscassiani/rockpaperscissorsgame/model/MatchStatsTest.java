package com.marcoscassiani.rockpaperscissorsgame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchStatsTest {

    MatchStats stats = new MatchStats();

    @Test
    void getTotalRounds() {
        int totalRounds = 10;
        stats.setTotalRounds(totalRounds);

        assertEquals(stats.getTotalRounds(), totalRounds);
    }

    @Test
    void getTotalWinsP1() {
        int totalWinsP1 = 4;
        stats.setTotalWinsP1(totalWinsP1);

        assertEquals(stats.getTotalWinsP1(), totalWinsP1);
    }

    @Test
    void getTotalWinsP2() {
        int totalWinsP2 = 5;
        stats.setTotalWinsP2(totalWinsP2);

        assertEquals(stats.getTotalWinsP2(), totalWinsP2);
    }

    @Test
    void getTotalDraws() {
        int totalDraws = 1;
        stats.setTotalDraws(totalDraws);

        assertEquals(stats.getTotalDraws(), totalDraws);
    }

}