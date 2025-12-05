package com.masBarato.masBarato.useCase.userDelete;

import com.masBarato.masBarato.domain.model.User;

public interface IUserDeleteFindInteractor {
    User findUserByUserId(Integer userId);
}
