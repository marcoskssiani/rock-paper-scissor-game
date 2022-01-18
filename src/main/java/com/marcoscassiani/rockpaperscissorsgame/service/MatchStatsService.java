package com.marcoscassiani.rockpaperscissorsgame.service;

import com.marcoscassiani.rockpaperscissorsgame.model.Match;
import com.marcoscassiani.rockpaperscissorsgame.model.MatchStats;
import com.marcoscassiani.rockpaperscissorsgame.model.RoundResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchStatsService {

    private final MatchService matchService;

    public MatchStatsService(MatchService matchService) {
        this.matchService = matchService;
    }

    public MatchStats get() {
        MatchStats stats = new MatchStats();

        stats.setTotalRounds(getTotalRounds());
        stats.setTotalWinsP1(getTotalWins(RoundResult.P1_WINS));
        stats.setTotalWinsP2(getTotalWins(RoundResult.P2_WINS));
        stats.setTotalDraws(getTotalWins(RoundResult.DRAW));
        return stats;
    }

    public long getTotalRounds() {
        return matchService
                .getAll()
                .values()
                .stream()
                .map(Match::getRounds)
                .mapToInt(List::size)
                .sum();
    }

    public long getTotalWins(RoundResult result) {
        return matchService
                .getAll()
                .values()
                .stream()
                .map(Match::getRounds)
                .flatMap(List::stream)
                .filter(round -> round.getResult().equals(result))
                .collect(Collectors.toList())
                .size();
    }

}