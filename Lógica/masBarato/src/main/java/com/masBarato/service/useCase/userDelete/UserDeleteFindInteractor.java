package com.masBarato.masBarato.service.useCase.userDelete;

import com.masBarato.masBarato.model.classes.User;
import com.masBarato.masBarato.service.UserServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDeleteFindInteractor implements IUserDeleteFindInteractor{
    private final UserServices userDeleteRepositoryPort;

    @Override
    public User findUserByUserId(String userId) {
        return userDeleteRepositoryPort.findUserByUserDeleteId(userId);
    }
}
