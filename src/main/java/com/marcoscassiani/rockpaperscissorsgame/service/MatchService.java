package com.marcoscassiani.rockpaperscissorsgame.service;

import com.marcoscassiani.rockpaperscissorsgame.model.Match;
import com.marcoscassiani.rockpaperscissorsgame.model.Round;
import com.marcoscassiani.rockpaperscissorsgame.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match create() {
        UUID matchId = UUID.randomUUID();
        return matchRepository.save(new Match(matchId));
    }

    public Match get(UUID matchId) {
        return matchRepository.get(matchId);
    }

    public Map<UUID, Match> getAll() {
        return matchRepository.getAll();
    }

    public Match addRound(final Round round) {
        Match match = matchRepository.get(round.getMatchId());
        match.getRounds().add(round);
        return matchRepository.update(match);
    }

}