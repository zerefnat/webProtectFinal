package com.masBarato.masBarato.useCase.User;

import com.masBarato.masBarato.domain.repository.IUserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDeleteInteractor implements IUserDeleteInteractor{
    private final IUserRepositoryPort userRepository;

    @Override
    public boolean deleteUserByUserId(Integer userId) {
        return userRepository.deleteUserByUserId(userId);
    }
}
