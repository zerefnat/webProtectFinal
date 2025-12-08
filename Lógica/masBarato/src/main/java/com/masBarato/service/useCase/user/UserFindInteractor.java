package com.masBarato.masBarato.service.useCase.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.User;
import com.masBarato.masBarato.service.UserServices;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserFindInteractor implements IUserFindInteractor{
    private final UserServices userRepositoryPort;
    @Override
    public User findUserByUserId(String userId) {
        return userRepositoryPort.findUserByUserId(userId);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepositoryPort.findUserByUserEmail(email);
    }

    @Override
    public List<User> findUserByFkUserId(String fkUserId) {
        return userRepositoryPort.findUserByFkUserId(fkUserId);
    }


}
