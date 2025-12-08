package com.masBarato.masBarato.dto.out;


import lombok.Builder;
@Builder
public record outAuth(
        String token,
        String rol,
        String userId
) {
}
