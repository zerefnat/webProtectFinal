package com.masBarato.masBarato.domain.repository;

import com.masBarato.masBarato.domain.model.User;

public interface IUserDeleteRepositoryPort {
    boolean addUserDelete(User userDeleted);

    User findUserByUserDeleteId(Integer userId);
}
