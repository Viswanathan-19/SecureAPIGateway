package com.viswa.gateway.api_gateway.filter;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {

        long startTime = System.currentTimeMillis();

        String path = exchange.getRequest().getURI().getPath();
        String method = exchange.getRequest().getMethod().name();
        String ip = exchange.getRequest().getRemoteAddress() != null
                ? exchange.getRequest().getRemoteAddress().getAddress().getHostAddress()
                : "unknown";

        log.info("Incoming Request → Method: {}, Path: {}, IP: {}", method, path, ip);

        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    long timeTaken = System.currentTimeMillis() - startTime;

                    int statusCode = exchange.getResponse().getStatusCode() != null
                            ? exchange.getResponse().getStatusCode().value()
                            : 0;

                    log.info("Response → Status: {}, Time: {} ms", statusCode, timeTaken);

                })
        );
    }

    @Override
    public int getOrder() {
        return -1; // high priority
    }

    @PostConstruct
    public void init() {
        System.out.println("LoggingFilter Loaded ✅");
    }


}