package com.marcoscassiani.rockpaperscissorsgame.controller;

import com.marcoscassiani.rockpaperscissorsgame.model.Match;
import com.marcoscassiani.rockpaperscissorsgame.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/matches")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("")
    public ResponseEntity<Match> create(){
        Match match = matchService.create();
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @GetMapping("{matchId}")
    public ResponseEntity<Match> get(@PathVariable final UUID matchId){
        Match match = matchService.get(matchId);
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Map<UUID, Match>> getAll(){
        Map<UUID, Match> match = matchService.getAll();
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

}