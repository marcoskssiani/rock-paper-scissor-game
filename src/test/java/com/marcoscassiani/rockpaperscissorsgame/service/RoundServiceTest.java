package com.marcoscassiani.rockpaperscissorsgame.service;

import com.marcoscassiani.rockpaperscissorsgame.model.Round;
import com.marcoscassiani.rockpaperscissorsgame.util.PlayerBehaviourUtils;
import com.marcoscassiani.rockpaperscissorsgame.util.RoundResolver;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoundServiceTest {

    @Autowired
    RoundService roundService;

    @Test
    void playRound() {

        UUID matchId = UUID.randomUUID();
        Round round = RoundResolver.resolve(PlayerBehaviourUtils.getPlayerOneShape(), PlayerBehaviourUtils.getPlayerTwoShape());
        round.setMatchId(matchId);

        Assertions.assertThat(roundService.playRound(matchId).getMatchId()).isEqualTo(matchId);
    }
}