package com.github.iamhi.hizone.feedbackservice.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record UserEntity(
    @Id
    String uuid,

    @Indexed(name = "user_entity_contact-info_index", unique = true, sparse = true)
    String contactInfo
) {
}
