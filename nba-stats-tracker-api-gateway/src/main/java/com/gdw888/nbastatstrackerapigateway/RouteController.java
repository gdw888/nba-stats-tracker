package com.gdw888.nbastatstrackerapigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class RouteController {

    @Autowired
    private RouteDefinitionLocator routeDefinitionLocator;

    @Autowired
    private RouteLocator routeLocator;

    @GetMapping("/routes")
    public Mono<Void> getRoutes() {
        return routeLocator.getRoutes()
                .doOnNext(route -> {
                    System.out.println("Route ID: " + route.getId() + ", URI: " + route.getUri() + ", Filters: " + route.getPredicate().toString()) ;
                })
                .then();
    }
}
