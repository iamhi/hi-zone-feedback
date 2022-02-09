package com.github.iamhi.hizone.feedbackservice.api.responses;

import java.util.List;

public record FeedbackResponse(String message, List<String> errors) {
}
