package com.gdw888.nbastatstrackerserver.controller;

import com.gdw888.nbastatstrackerserver.entity.NbaPlayerInfo;
import com.gdw888.nbastatstrackerserver.service.NbaPlayerInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nba-players")
public class NbaPlayerInfoController {

    private final NbaPlayerInfoService playerInfoService;

    public NbaPlayerInfoController(NbaPlayerInfoService playerInfoService) {
        this.playerInfoService = playerInfoService;
    }

    @GetMapping
    public List<NbaPlayerInfo> getAllNbaPlayerInfo() {
        return playerInfoService.getAllNbaPlayerInfo();
    }

    @GetMapping("/{playerName}")
    public NbaPlayerInfo getNbaPlayerInfo(@PathVariable String playerName) {
        return playerInfoService.getNbaPlayerInfo(playerName);
    }

    @PostMapping
    public void saveNbaPlayerInfo(@RequestBody NbaPlayerInfo playerInfo) {
        playerInfoService.saveNbaPlayerInfo(playerInfo);
    }

    @DeleteMapping
    public void deleteNbaPlayerInfo(@RequestBody NbaPlayerInfo playerInfo) {
        playerInfoService.deleteNbaPlayerInfo(playerInfo);
    }

    @DeleteMapping("/{playerName}")
    public void deleteNbaPlayerInfoByPlayerName(@PathVariable String playerName) {
        playerInfoService.deleteNbaPlayerInfoByPlayerName(playerName);
    }
}
