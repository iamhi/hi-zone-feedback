package com.github.iamhi.hizone.feedbackservice.api.requests;

import org.springframework.util.MultiValueMap;

public record FeedbackRequest(String feedbackTextarea) {
    public static FeedbackRequest fromFormData(MultiValueMap<String, String> formData) {
        return new FeedbackRequest(formData.getFirst("feedback-textarea"));
    }
}
