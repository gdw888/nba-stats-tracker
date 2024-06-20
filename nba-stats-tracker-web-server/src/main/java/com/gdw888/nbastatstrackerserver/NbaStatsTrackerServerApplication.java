package com.gdw888.nbastatstrackerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NbaStatsTrackerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbaStatsTrackerServerApplication.class, args);
	}

}
