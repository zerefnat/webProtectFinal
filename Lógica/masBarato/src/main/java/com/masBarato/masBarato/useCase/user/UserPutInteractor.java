package com.masBarato.masBarato.useCase.user;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.domain.repository.IUserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class UserPutInteractor implements IUserPutInteractor{
    private final IUserRepositoryPort userRepositoryPort;


    @Override
    public Boolean updateUser(Integer userId ,User user) {
        return userRepositoryPort.updateUser(userId,user);
    }
}
