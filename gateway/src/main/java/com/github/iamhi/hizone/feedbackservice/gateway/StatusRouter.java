package com.github.iamhi.hizone.feedbackservice.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class StatusRouter {

    private static final String ROUTER_PREFIX = "/status";

    @Bean
    public RouterFunction<ServerResponse> pingRoute() {
        return route(GET(ROUTER_PREFIX + "/ping"), serverRequest ->
            ServerResponse.ok().bodyValue("pong"));
    }
}
