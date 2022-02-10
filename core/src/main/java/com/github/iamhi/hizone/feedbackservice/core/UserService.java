package com.github.iamhi.hizone.feedbackservice.core;

import com.github.iamhi.hizone.feedbackservice.core.dto.UserDTO;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserDTO> createOrFindUser(String contactInfo);
}
