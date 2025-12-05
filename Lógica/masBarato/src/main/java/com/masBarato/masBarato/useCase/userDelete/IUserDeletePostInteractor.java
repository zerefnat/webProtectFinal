package com.masBarato.masBarato.useCase.userDelete;

import com.masBarato.masBarato.domain.model.User;

public interface IUserDeletePostInteractor {
    boolean addUserDelete(User userDeletedEntity);
}
