package com.masBarato.masBarato.useCase.User;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.domain.repository.IUserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFindInteractor implements IUserFindInteractor{
    private final IUserRepositoryPort userRepositoryPort;
    @Override
    public User findUserByUserId(Integer userId) {
        return userRepositoryPort.findUserByUserId(userId);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepositoryPort.findUserByUserEmail(email);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepositoryPort.findUserByUsername(username);
    }


}
