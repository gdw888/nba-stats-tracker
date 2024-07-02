package com.gdw888.nbastatstrackerapigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("nba-stats-tracker-web-server-api", r -> r.path("/api/**")
                        //.filters(f -> f.removeRequestHeader("Origin"))
                        .filters(f -> f.circuitBreaker(c -> c.setName("NbaStatsTrackerRestAPIs")
                                        .setFallbackUri("forward:/fallback/NbaStatsTrackerServer"))
                                .removeRequestHeader("Origin"))
                        .uri("lb://nba-stats-tracker-web-server"))
                .build();
    }
}
