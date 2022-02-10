package com.github.iamhi.hizone.feedbackservice.core.dto;

import com.github.iamhi.hizone.feedbackservice.data.UserEntity;

public record UserDTO(
    String uuid,
    String contactInfo
) {
    public static UserDTO fromEntity(UserEntity userEntity) {
        return new UserDTO(
            userEntity.uuid(),
            userEntity.contactInfo()
        );
    }
}
