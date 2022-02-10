package com.github.iamhi.hizone.feedbackservice.gateway;

import com.github.iamhi.hizone.feedbackservice.api.requests.FeedbackRequest;
import com.github.iamhi.hizone.feedbackservice.core.FeedbackService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public record FeedbackHandler(
    FeedbackService feedbackService
) {
    public Mono<ServerResponse> postFeedback(ServerRequest serverRequest) {
        return serverRequest.formData().map(FeedbackRequest::fromFormData)
            .flatMap(feedbackRequest -> feedbackService.postFeedback(feedbackRequest.feedbackTextarea(), feedbackRequest.contactInfo()))
            .flatMap(response -> ServerResponse.ok()
                .render("feedback-submitted", Map.of("response", response)))
            .onErrorResume(error -> ServerResponse.badRequest().render("feedback-form", Map.of("error", error)));
    }
}
