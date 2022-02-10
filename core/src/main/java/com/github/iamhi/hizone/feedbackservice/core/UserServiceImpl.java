package com.github.iamhi.hizone.feedbackservice.core;

import com.github.iamhi.hizone.feedbackservice.core.dto.UserDTO;
import com.github.iamhi.hizone.feedbackservice.data.UserEntity;
import com.github.iamhi.hizone.feedbackservice.data.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public record UserServiceImpl(
    UserRepository userRepository
) implements UserService {

    @Override
    public Mono<UserDTO> createOrFindUser(String contactInfo) {
        return userRepository.findByContactInfo(contactInfo)
            .switchIfEmpty(
                userRepository.save(new UserEntity(
                    UUID.randomUUID().toString(),
                    contactInfo
                ))
            )
            .map(UserDTO::fromEntity);
    }
}
