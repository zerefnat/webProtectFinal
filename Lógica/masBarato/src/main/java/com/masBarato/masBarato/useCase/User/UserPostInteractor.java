package com.masBarato.masBarato.useCase.User;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.domain.repository.IUserRepositoryPort;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Component
public class UserPostInteractor implements IUserPostInteractor{
    private final IUserRepositoryPort userRepositoryPort;

    public Boolean newUser(User user) {
        return userRepositoryPort.newUser(user);
    }


}
