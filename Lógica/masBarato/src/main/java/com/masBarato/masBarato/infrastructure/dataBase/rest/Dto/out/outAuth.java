package com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.out;


import lombok.Builder;
@Builder
public record outAuth(
        String token,
        String rol,
        Integer userId
) {
}
