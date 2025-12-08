package com.masBarato.masBarato.service.useCase.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.User;
import com.masBarato.masBarato.service.UserServices;


@RequiredArgsConstructor
@Component
public class UserPutInteractor implements IUserPutInteractor{
    private final UserServices userRepositoryPort;


    @Override
    public Boolean updateUser(String userId ,User user) {
        return userRepositoryPort.updateUser(userId,user);
    }
}
