package com.marcoscassiani.rockpaperscissorsgame.service;

import com.marcoscassiani.rockpaperscissorsgame.util.RoundResolver;
import com.marcoscassiani.rockpaperscissorsgame.model.Round;
import com.marcoscassiani.rockpaperscissorsgame.util.PlayerBehaviourUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoundService {

    public Round playRound(final UUID matchId) {
        Round round = RoundResolver.resolve(PlayerBehaviourUtils.getPlayerOneShape(), PlayerBehaviourUtils.getPlayerTwoShape());
        round.setMatchId(matchId);
        return round;
    }
}