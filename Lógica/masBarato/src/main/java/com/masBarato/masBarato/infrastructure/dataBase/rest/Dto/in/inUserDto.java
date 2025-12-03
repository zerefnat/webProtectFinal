package com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.in;

import com.masBarato.masBarato.domain.model.User;

public record inUserDto(
        Integer userId,
        String name,
        String firstLastName,
        String secondLastName,
        String gmail,
        String userName,
        String password,
        Integer rolesID,
        Integer fk_userId
) {
    public static User fromUserDtoToUser(inUserDto userDto) {
        User user = null;
        if(userDto!=null)
            user = new User(
                    userDto.userId(),
                    userDto.name(),
                    userDto.firstLastName(),
                    userDto.secondLastName(),
                    userDto.gmail(),
                    userDto.userName(),
                    userDto.password(),
                    userDto.rolesID(),
                    userDto.fk_userId());
        return user;
    }
}
