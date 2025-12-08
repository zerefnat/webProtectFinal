package com.masBarato.masBarato.service.useCase.user;


import java.util.List;

import com.masBarato.masBarato.model.classes.User;

public interface IUserFindInteractor {
    User findUserByUserId(String userId);
    User findUserByEmail(String email);
    List<User> findUserByFkUserId(String fkUserId);
}
