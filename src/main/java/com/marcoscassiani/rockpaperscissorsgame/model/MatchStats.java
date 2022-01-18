package com.marcoscassiani.rockpaperscissorsgame.model;

import lombok.Data;

@Data
public class MatchStats {

    private long totalRounds;
    private long totalWinsP1;
    private long totalWinsP2;
    private long totalDraws;
}
