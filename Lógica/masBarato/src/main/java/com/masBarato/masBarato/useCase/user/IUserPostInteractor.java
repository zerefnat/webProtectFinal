package com.masBarato.masBarato.useCase.user;

import com.masBarato.masBarato.domain.model.User;

public interface IUserPostInteractor {
    Boolean newUser(User user);
}
