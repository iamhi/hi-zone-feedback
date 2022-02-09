package com.github.iamhi.hizone.feedbackservice.gateway;

import com.github.iamhi.hizone.feedbackservice.api.requests.FeedbackRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class FeedbackHandler {

    public Mono<ServerResponse> postFeedback(ServerRequest serverRequest) {
        return serverRequest.formData().map(FeedbackRequest::fromFormData)
            .map(FeedbackRequest::feedbackTextarea)
            .flatMap(response -> ServerResponse.ok()
                .render("feedback-submitted", Map.of("response", response)))
            .onErrorResume(error -> ServerResponse.badRequest().render("feedback-form", Map.of("error", error)));
    }
}
