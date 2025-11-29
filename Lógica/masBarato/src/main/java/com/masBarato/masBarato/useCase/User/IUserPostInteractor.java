package com.masBarato.masBarato.useCase.User;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserEntity;

public interface IUserPostInteractor {
    Boolean newUser(User user);
}
