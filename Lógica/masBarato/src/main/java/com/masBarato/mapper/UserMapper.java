package com.masBarato.masBarato.mapper;

import com.masBarato.masBarato.model.classes.User;
import com.masBarato.masBarato.model.entity.RolEntity;
import com.masBarato.masBarato.model.entity.UserDeletedEntity;
import com.masBarato.masBarato.model.entity.UserEntity;

public class UserMapper {
    public static User fromUserEntityToUser(UserEntity userEntity) {
        if(userEntity==null) return null;
        return new User(
                userEntity.getUserId(),
                userEntity.getName(),
                userEntity.getFirstLastName(),
                userEntity.getSecondLastName(),
                userEntity.getGmail(),
                userEntity.getPassword(),
                userEntity.getRol().getRolId(),
                userEntity.getFkUserId().getUserId()
        );
    }

    public static UserEntity fromUserToUserEntity(User user) {

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(user.getUserId());
        userEntity.setName(user.getName());
        userEntity.setFirstLastName(user.getFirstLastName());
        userEntity.setSecondLastName(user.getSecondLastName());
        userEntity.setGmail(user.getGmail());
        userEntity.setPassword(user.getPassword());
        RolEntity rol = new RolEntity();
        rol.setRolId(user.getRoles());
        userEntity.setRol(rol);
        if (user.getFk_userId() != null) {
            UserEntity creador = new UserEntity();
            creador.setUserId(user.getFk_userId());
            userEntity.setFkUserId(creador);
        } else {
            userEntity.setFkUserId(null);
        }
        return userEntity;
    }

    public static UserDeletedEntity fromUserToUserDeleteEntity(User user) {
        UserDeletedEntity userDeleted = new UserDeletedEntity();
        userDeleted.setUserId(user.getUserId());
        userDeleted.setName(user.getName());
        userDeleted.setFirstLastName(user.getFirstLastName());
        userDeleted.setSecondLastName(user.getSecondLastName());
        userDeleted.setGmail(user.getGmail());
        userDeleted.setPassword(user.getPassword());
        RolEntity rol = new RolEntity();
        rol.setRolId(user.getRoles());
        userDeleted.setRol(rol);
        if (user.getFk_userId() != null) {
            UserEntity creador = new UserEntity();
            creador.setUserId(user.getFk_userId());
            userDeleted.setFkUserId(creador);
        } else {
            userDeleted.setFkUserId(null);
        }
        return userDeleted;
    }

    public static User fromUserDeleteEntityToUser(UserDeletedEntity userDeleted) {
        return new User(
                userDeleted.getUserId(),
                userDeleted.getName(),
                userDeleted.getFirstLastName(),
                userDeleted.getSecondLastName(),
                userDeleted.getGmail(),
                userDeleted.getPassword(),
                userDeleted.getRol().getRolId(),
                userDeleted.getFkUserId().getUserId()
        );
    }
}