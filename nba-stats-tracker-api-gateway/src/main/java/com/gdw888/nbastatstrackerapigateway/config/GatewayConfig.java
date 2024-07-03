package com.gdw888.nbastatstrackerapigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private GatewayFilter customRateLimiterFilter;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("nba-stats-tracker-web-server-api", r -> r.path("/api/**")
                        .filters(f -> f.circuitBreaker(c -> c.setName("NbaStatsTrackerRestAPIs")
                                        .setFallbackUri("forward:/fallback/NbaStatsTrackerServer"))
                                .removeRequestHeader("Origin")
                                .filter(customRateLimiterFilter))
                        .uri("lb://nba-stats-tracker-web-server"))
                .build();
    }
}
