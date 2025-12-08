package com.masBarato.masBarato.dto.out;

import com.masBarato.masBarato.model.classes.User;

public record outUserDto(
        String userId,
        String name,
        String firstLastName,
        String secondLastName,
        String gmail,
        String rolesName
) {
    public static outUserDto fromUserToUserDto(User user,String rolesName) {
        outUserDto dto = null;
        if(user!=null)
            dto = new outUserDto(
                    user.getUserId(),
                    user.getName(),
                    user.getFirstLastName(),
                    user.getSecondLastName(),
                    user.getGmail(),
                    rolesName
            );
        return dto;
    }

}
