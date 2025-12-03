package com.masBarato.masBarato.useCase.UserDelete;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserDeletedEntity;

public interface IUserDeletePostInteractor {
    boolean addUserDelete(User userDeletedEntity);
}
