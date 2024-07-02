package com.gdw888.nbastatstrackerapigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/NbaStatsTrackerServer")
    public String NbaStatsTrackerServer() {
        return "NbaStatsTrackerServer is currently unavailable. Please try again later.";
    }
}