package com.masBarato.masBarato.useCase.user;

import com.masBarato.masBarato.domain.model.User;

public interface IUserPutInteractor {
    Boolean updateUser(Integer id, User user);
}
