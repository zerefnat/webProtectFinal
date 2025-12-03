package com.masBarato.masBarato.useCase.UserDelete;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.domain.repository.IUserDeleteRepositoryPort;

public class UserDeletePostInteractor implements IUserDeletePostInteractor {

    private final IUserDeleteRepositoryPort iUserDeleteRepositoryPort;

    public UserDeletePostInteractor(IUserDeleteRepositoryPort iUserDeleteRepositoryPort) {
        this.iUserDeleteRepositoryPort = iUserDeleteRepositoryPort;
    }

    @Override
    public boolean addUserDelete(User userDeleted) {
        return iUserDeleteRepositoryPort.addUserDelete(userDeleted);
    }
}
