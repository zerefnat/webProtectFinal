package com.masBarato.masBarato.service.useCase.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.User;
import com.masBarato.masBarato.service.UserServices;


@RequiredArgsConstructor
@Component
public class UserPostInteractor implements IUserPostInteractor{
    private final UserServices userRepositoryPort;

    public Boolean newUser(User user) {
        return userRepositoryPort.newUser(user);
    }


}
