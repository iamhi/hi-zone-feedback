package com.github.iamhi.hizone.feedbackservice.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FeedbackRouter {

    private static final String ROUTER_PREFIX = "";

    @Bean
    public RouterFunction<ServerResponse> feedbackCompose(FeedbackHandler feedbackHandler) {
        return
            route(POST(ROUTER_PREFIX).and(accept(MediaType.MULTIPART_FORM_DATA)), feedbackHandler::postFeedback)
            .and(route(GET(ROUTER_PREFIX), serverRequest -> ServerResponse.ok().render("feedback-form")));
    }
}
