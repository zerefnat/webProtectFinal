package com.masBarato.masBarato.infrastructure.dataBase.sql.mapper;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.RolEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserEntity;

public class UserMapper {
    public static User fromUserEntityToUser(UserEntity userEntity) {
        if(userEntity==null) return null;
        return new User(
                userEntity.getUserId(),
                userEntity.getName(),
                userEntity.getFirstLastName(),
                userEntity.getSecondLastName(),
                userEntity.getGmail(),
                userEntity.getUserName(),
                userEntity.getPassword(),
                userEntity.getRol().getRolName()
        );
    }

    public static UserEntity fromUserToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(user.getUserId());
        userEntity.setName(user.getName());
        userEntity.setFirstLastName(user.getFirstLastName());
        userEntity.setSecondLastName(user.getSecondLastName());
        userEntity.setGmail(user.getGmail());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        RolEntity rol = new RolEntity();
        rol.setRolId(Integer.parseInt(user.getRoles()));
        userEntity.setRol(rol);
       return userEntity;
    }
}