package com.masBarato.masBarato.service.useCase.userDelete;

import com.masBarato.masBarato.model.classes.User;

public interface IUserDeleteFindInteractor {
    User findUserByUserId(String userId);
}
