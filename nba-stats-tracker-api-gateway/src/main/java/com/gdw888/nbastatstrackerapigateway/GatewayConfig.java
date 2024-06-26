package com.gdw888.nbastatstrackerapigateway;

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
                        .filters(f -> f.removeRequestHeader("Origin"))
                        .uri("lb://nba-stats-tracker-web-server"))
                .route("nba-stats-tracker-web-server-auth", r -> r.path("/auth/**")
                        .filters(f -> f.removeRequestHeader("Origin"))
                        .uri("lb://nba-stats-tracker-web-server"))
                .build();
    }
}
