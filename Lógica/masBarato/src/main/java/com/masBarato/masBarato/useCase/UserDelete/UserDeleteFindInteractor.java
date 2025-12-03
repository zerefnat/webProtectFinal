package com.masBarato.masBarato.useCase.UserDelete;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.domain.repository.IUserDeleteRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDeleteFindInteractor implements IUserDeleteFindInteractor{
    private final IUserDeleteRepositoryPort userDeleteRepositoryPort;

    @Override
    public User findUserByUserId(Integer userId) {
        return userDeleteRepositoryPort.findUserByUserDeleteId(userId);
    }
}
