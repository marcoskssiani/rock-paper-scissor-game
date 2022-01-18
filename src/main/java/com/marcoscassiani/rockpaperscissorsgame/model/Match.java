package com.marcoscassiani.rockpaperscissorsgame.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Match {

    private UUID id;
    private List<Round> rounds;

    public Match() {}

    public Match(UUID id) {
        this.id = id;
        this.rounds = new ArrayList<>();
    }

}