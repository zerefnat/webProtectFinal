package com.masBarato.masBarato.useCase.User;

import com.masBarato.masBarato.domain.model.User;

public interface IUserFindInteractor {
    User findUserByUserId(Integer userId);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
}
