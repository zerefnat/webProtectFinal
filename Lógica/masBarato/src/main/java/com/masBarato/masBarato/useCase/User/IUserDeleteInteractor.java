package com.masBarato.masBarato.useCase.User;

import com.masBarato.masBarato.domain.model.User;

public interface IUserDeleteInteractor {
    boolean deleteUserByUserId(Integer userId);
}
