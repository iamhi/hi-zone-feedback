package com.github.iamhi.hizone.feedbackservice.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record FeedbackEntity(
    @Id
    String uuid,

    String content,

    String userUuid
) {
}
