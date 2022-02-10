package com.github.iamhi.hizone.feedbackservice.core;

import com.github.iamhi.hizone.feedbackservice.core.dto.FeedbackDTO;
import reactor.core.publisher.Mono;

public interface FeedbackService {

    Mono<FeedbackDTO> postFeedback(String content, String contactInfo);
}
