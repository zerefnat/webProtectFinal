package com.masBarato.masBarato.service.useCase.userDelete;

import com.masBarato.masBarato.model.classes.User;
import com.masBarato.masBarato.service.UserServices;

public class UserDeletePostInteractor implements IUserDeletePostInteractor {

    private final UserServices iUserDeleteRepositoryPort;

    public UserDeletePostInteractor(UserServices iUserDeleteRepositoryPort) {
        this.iUserDeleteRepositoryPort = iUserDeleteRepositoryPort;
    }

    @Override
    public boolean addUserDelete(User userDeleted) {
        return iUserDeleteRepositoryPort.addUserDelete(userDeleted);
    }
}
