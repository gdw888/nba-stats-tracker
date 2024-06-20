package com.gdw888.nbastatstrackerservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NbaStatsTrackerServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbaStatsTrackerServiceDiscoveryApplication.class, args);
    }

}
