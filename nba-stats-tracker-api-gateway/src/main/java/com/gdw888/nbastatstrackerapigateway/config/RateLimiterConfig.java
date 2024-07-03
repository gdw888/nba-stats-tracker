package com.gdw888.nbastatstrackerapigateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimiterConfig {

    @Value("${rate-limit.defaultReplenishRate}")
    private int defaultReplenishRate;

    @Value("${rate-limit.defaultBurstCapacity}")
    private int defaultBurstCapacity;

    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(defaultReplenishRate, defaultBurstCapacity); // per minute with a burst capacity
    }
}