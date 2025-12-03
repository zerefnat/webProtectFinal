package com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.out;


import com.masBarato.masBarato.domain.model.User;

public record outUserDto(
        Integer userId,
        String name,
        String firstLastName,
        String secondLastName,
        String gmail,
        String userName,
        String rolesName
) {
    public static outUserDto fromUserToUserDto(User user,String rolesName) {
        outUserDto dto = null;
        if(user!=null)
            dto = new outUserDto(
                    user.getUserId(),
                    user.getUserName(),
                    user.getFirstLastName(),
                    user.getSecondLastName(),
                    user.getGmail(),
                    user.getUserName(),
                    rolesName
            );
        return dto;
    }

}
