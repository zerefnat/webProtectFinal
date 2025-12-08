package com.masBarato.masBarato.service.useCase.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.service.UserServices;

@Component
@RequiredArgsConstructor
public class UserDeleteInteractor implements IUserDeleteInteractor{
    private final UserServices userRepository;

    @Override
    public boolean deleteUserByUserId(String userId) {
        return userRepository.deleteUserByUserId(userId);
    }
}
