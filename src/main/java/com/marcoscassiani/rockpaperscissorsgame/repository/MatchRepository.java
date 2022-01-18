package com.marcoscassiani.rockpaperscissorsgame.repository;

import com.marcoscassiani.rockpaperscissorsgame.model.Match;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MatchRepository {

    Map<UUID, Match> matches;

    public MatchRepository() {
        this.matches = new HashMap<>();
    }

    public Match save(Match match) {
        this.matches.put(match.getId(), match);
        return match;
    }

    public Match update(final Match match) {
        this.matches.get(match.getId()).setRounds(match.getRounds());
        return match;
    }

    public Match get(UUID matchId) throws NoSuchElementException {
        return Optional.ofNullable(matches.get(matchId)).orElseThrow(() -> new NoSuchElementException("The requested match does not exists."));
    }

    public Map<UUID, Match> getAll() {
        return this.matches;
    }

}