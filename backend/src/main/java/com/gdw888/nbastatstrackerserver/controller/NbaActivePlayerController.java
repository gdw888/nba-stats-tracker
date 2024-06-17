package com.gdw888.nbastatstrackerserver.controller;

import com.gdw888.nbastatstrackerserver.entity.NbaActivePlayer;
import com.gdw888.nbastatstrackerserver.service.NbaActivePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NbaActivePlayerController {

    @Autowired
    private NbaActivePlayerService nbaActivePlayerService;

    @GetMapping("/players")
    public List<NbaActivePlayer> getData() {
        return nbaActivePlayerService.getData();
    }

    @PostMapping("/players")
    public void saveData(@RequestBody NbaActivePlayer nbaActivePlayer) {
        nbaActivePlayerService.saveData(nbaActivePlayer);
    }
}
