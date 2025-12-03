package com.masBarato.masBarato.useCase.UserDelete;

import com.masBarato.masBarato.domain.model.User;

public interface IUserDeleteFindInteractor {
    User findUserByUserId(Integer userId);
}
