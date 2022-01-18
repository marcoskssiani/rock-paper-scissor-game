package com.marcoscassiani.rockpaperscissorsgame.controller;

import com.marcoscassiani.rockpaperscissorsgame.model.MatchStats;
import com.marcoscassiani.rockpaperscissorsgame.service.MatchStatsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches-stats")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class MatchStatsController {

    private final MatchStatsService matchStatsService;

    public MatchStatsController(MatchStatsService matchStatsService) {
        this.matchStatsService = matchStatsService;
    }

    @GetMapping("")
    public ResponseEntity<MatchStats> get(){
        MatchStats stats = matchStatsService.get();
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

}