package com.masBarato.masBarato.useCase.User;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.domain.repository.IUserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class UserPostInteractor implements IUserPostInteractor{
    private final IUserRepositoryPort userRepositoryPort;

    public Boolean newUser(User user) {
        return userRepositoryPort.newUser(user);
    }


}
