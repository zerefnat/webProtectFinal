package com.masBarato.masBarato.dto.in;

import com.masBarato.masBarato.model.classes.User;

public record inUserDto(
        String userId,
        String name,
        String firstLastName,
        String secondLastName,
        String gmail,
        String password,
        Integer rolesID,
        String fk_userId
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
                    userDto.password(),
                    userDto.rolesID(),
                    userDto.fk_userId());
        return user;
    }
}
