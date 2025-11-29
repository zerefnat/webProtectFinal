package com.masBarato.masBarato.domain.repository;

import com.masBarato.masBarato.domain.model.User;
public interface IUserRepositoryPort {
    User findUserByUserId(Integer userId);
    User findUserByUserEmail(String email);
    boolean deleteUserByUserId(Integer userId);
    Boolean newUser(User user);
    Boolean updateUser(Integer userId,User user);
    User findUserByUsername(String username);
}
