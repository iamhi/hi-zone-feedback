package com.github.iamhi.hizone.feedbackservice.core.dto;

import com.github.iamhi.hizone.feedbackservice.data.FeedbackEntity;

public record FeedbackDTO(String uuid, String content, String userUuid) {

    public static FeedbackDTO fromEntity(FeedbackEntity feedbackEntity) {
        return new FeedbackDTO(
            feedbackEntity.uuid(),
            feedbackEntity.content(),
            feedbackEntity.userUuid()
        );
    }
}
