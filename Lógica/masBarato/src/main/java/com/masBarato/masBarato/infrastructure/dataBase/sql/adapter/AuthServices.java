package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;


import com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.in.InLogin;
import com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.out.outAuth;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServices {

    private final UserJpaRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;

    public outAuth login(InLogin request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        UserEntity user = userRepository.findUserByUserName(request.username());
        String token = jwtService.getToken(user);
        return outAuth.builder().token(token).rol(user.getRol().getRolName()).userId(user.getUserId()).build();
    }
}
