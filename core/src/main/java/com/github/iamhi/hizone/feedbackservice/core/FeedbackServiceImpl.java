package com.github.iamhi.hizone.feedbackservice.core;

import com.github.iamhi.hizone.feedbackservice.core.dto.FeedbackDTO;
import com.github.iamhi.hizone.feedbackservice.core.dto.UserDTO;
import com.github.iamhi.hizone.feedbackservice.data.FeedbackEntity;
import com.github.iamhi.hizone.feedbackservice.data.FeedbackRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
record FeedbackServiceImpl(
    FeedbackRepository feedbackRepository,
    UserService userService
) implements FeedbackService {

    @Override
    public Mono<FeedbackDTO> postFeedback(String content, String contactInfo) {

        return userService().createOrFindUser(contactInfo)
            .map(UserDTO::uuid)
            .map(userUuid -> new FeedbackEntity(
                UUID.randomUUID().toString(),
                content,
                userUuid
            )).flatMap(feedbackRepository::save).map(FeedbackDTO::fromEntity);
    }
}
