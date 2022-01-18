package com.marcoscassiani.rockpaperscissorsgame.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Round {

    HandShape player1Shape;
    HandShape player2Shape;
    RoundResult result;
    UUID matchId;

    public Round() {}

    public Round(HandShape player1Shape, HandShape player2Shape, RoundResult result) {
        this.player1Shape = player1Shape;
        this.player2Shape = player2Shape;
        this.result = result;
    }
}