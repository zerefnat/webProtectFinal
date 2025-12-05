package com.masBarato.masBarato.useCase.user;

import com.masBarato.masBarato.domain.model.User;

import java.util.List;

public interface IUserFindInteractor {
    User findUserByUserId(Integer userId);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    List<User> findUserByFkUserId(Integer fkUserId);
}
