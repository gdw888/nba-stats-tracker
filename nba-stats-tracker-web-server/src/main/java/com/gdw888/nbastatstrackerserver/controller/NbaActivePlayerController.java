package com.gdw888.nbastatstrackerserver.controller;

import com.gdw888.nbastatstrackerserver.entity.NbaActivePlayer;
import com.gdw888.nbastatstrackerserver.service.NbaActivePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NbaActivePlayerController {

    @Autowired
    private NbaActivePlayerService nbaActivePlayerService;

    @GetMapping("/active-players")
    public List<NbaActivePlayer> getAllActivePlayers() {
        return nbaActivePlayerService.getAllActivePlayers();
    }

    @GetMapping("/active-player")
    public NbaActivePlayer getActivePlayer(@RequestBody NbaActivePlayer nbaActivePlayer) {
        NbaActivePlayer newPlayer = new NbaActivePlayer(nbaActivePlayer.getName(),nbaActivePlayer.getUrl());
        return nbaActivePlayerService.getActivePlayer(newPlayer);
    }

    @PostMapping("/active-player")
    public void saveActivePlayer(@RequestBody NbaActivePlayer nbaActivePlayer) {
        NbaActivePlayer newPlayer = new NbaActivePlayer(nbaActivePlayer.getName(),nbaActivePlayer.getUrl());
        nbaActivePlayerService.saveActivePlayer(newPlayer);
    }

    @PutMapping("/active-player")
    public void updateActivePlayer(@RequestBody NbaActivePlayer nbaActivePlayer) {
        NbaActivePlayer newPlayer = new NbaActivePlayer(nbaActivePlayer.getName(),nbaActivePlayer.getUrl());
        nbaActivePlayerService.saveActivePlayer(newPlayer);
    }

    @DeleteMapping("/active-players/{playerName}")
    public ResponseEntity<?> deleteActivePlayerByName(@PathVariable String playerName) {
        try {
            nbaActivePlayerService.deleteActivePlayerByName(playerName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete player: " + e.getMessage());
        }
    }
}
