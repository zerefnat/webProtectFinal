package com.masBarato.masBarato.service.useCase.user;

import com.masBarato.masBarato.model.classes.User;

public interface IUserPutInteractor {
    Boolean updateUser(String id, User user);
}
