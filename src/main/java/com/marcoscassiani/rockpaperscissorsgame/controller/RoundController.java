package com.marcoscassiani.rockpaperscissorsgame.controller;

import com.marcoscassiani.rockpaperscissorsgame.model.Round;
import com.marcoscassiani.rockpaperscissorsgame.service.MatchService;
import com.marcoscassiani.rockpaperscissorsgame.service.RoundService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/matches/*/rounds")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class RoundController {

    private final RoundService roundService;
    private final MatchService matchService;

    public RoundController(RoundService roundService, MatchService matchService) {
        this.roundService = roundService;
        this.matchService = matchService;
    }

    @PostMapping("matches/{matchId}/rounds")
    public ResponseEntity<Round> playRound(@PathVariable final UUID matchId){
        Round round = roundService.playRound(matchId);
        matchService.addRound(round);
        return new ResponseEntity<>(round, HttpStatus.OK);
    }

}