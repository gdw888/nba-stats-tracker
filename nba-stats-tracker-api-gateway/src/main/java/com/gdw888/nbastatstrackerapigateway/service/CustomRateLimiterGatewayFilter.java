package com.gdw888.nbastatstrackerapigateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CustomRateLimiterGatewayFilter implements GatewayFilter {

    @Autowired
    private RedisRateLimiter redisRateLimiter;

    @Autowired
    private KeyResolver ipKeyResolver;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpMethod method = exchange.getRequest().getMethod();
        if (method == HttpMethod.POST || method == HttpMethod.DELETE || method == HttpMethod.PUT) {
            return ipKeyResolver.resolve(exchange).flatMap(key ->
                    redisRateLimiter.isAllowed(key, String.valueOf(1)).flatMap(response -> {
                        if (response.isAllowed()) {
                            return chain.filter(exchange);
                        } else {
                            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                            return exchange.getResponse().setComplete();
                        }
                    })
            );
        }
        return chain.filter(exchange);
    }
}
