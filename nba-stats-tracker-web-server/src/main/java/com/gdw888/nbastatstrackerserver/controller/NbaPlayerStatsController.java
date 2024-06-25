package com.gdw888.nbastatstrackerserver.controller;

import com.gdw888.nbastatstrackerserver.entity.NbaPlayerStats;
import com.gdw888.nbastatstrackerserver.service.NbaPlayerStatsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nba-player-stats")
public class NbaPlayerStatsController {

    private final NbaPlayerStatsService playerStatsService;

    public NbaPlayerStatsController(NbaPlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    @GetMapping
    public List<NbaPlayerStats> getAllNbaPlayerStats() {
        return playerStatsService.getAllNbaPlayerStats();
    }

    @GetMapping("/{playerName}/{date}")
    public NbaPlayerStats getNbaPlayerStats(@PathVariable String playerName, @PathVariable String date) {
        return playerStatsService.getNbaPlayerStats(playerName, date);
    }

    @PostMapping
    public void saveNbaPlayerStats(@RequestBody NbaPlayerStats playerStats) {
        playerStatsService.saveNbaPlayerStats(playerStats);
    }

    @DeleteMapping
    public void deleteNbaPlayerStats(@RequestBody NbaPlayerStats playerStats) {
        playerStatsService.deleteNbaPlayerStats(playerStats);
    }

    @DeleteMapping("/{playerName}/{date}")
    public void deleteNbaPlayerStatsByPlayerNameAndDate(@PathVariable String playerName, @PathVariable String date) {
        playerStatsService.deleteNbaPlayerStatsByPlayerNameAndDate(playerName, date);
    }
}
