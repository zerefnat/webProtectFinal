package com.masBarato.masBarato.infrastructure.dataBase.rest.Dto;

import com.masBarato.masBarato.domain.model.User;

import java.util.Objects;

public record UserDto(
        Integer userId,
        String name,
        String firstLastName,
        String secondLastName,
        String gmail,
        String userName,
        String rolesID
) {
    public static UserDto fromUserToUserDto(User user) {
        if(user==null) return null;
        return new UserDto(
                user.getUserId(),
                user.getName(),
                user.getFirstLastName(),
                user.getSecondLastName(),
                user.getGmail(),
                user.getUserName(),
                user.getRoles()
        );

    }

    public static User fromUserDtoToUser(UserDto userDto) {
        if(userDto==null) return null;
        return new User(
                userDto.userId(),
                userDto.name(),
                userDto.firstLastName(),
                userDto.secondLastName(),
                userDto.gmail(),
                userDto.userName(),
                "1234",
                Objects.equals(userDto.rolesID(), "Administrador") ?"1":Objects.equals(userDto.rolesID(), "Gestor") ?"3":"2"
        );
    }
}
