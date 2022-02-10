package com.github.iamhi.hizone.feedbackservice.data;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface FeedbackRepository extends ReactiveMongoRepository<FeedbackEntity, String> {

    Flux<FeedbackEntity> findByUserUuid(String userUuid);
}
