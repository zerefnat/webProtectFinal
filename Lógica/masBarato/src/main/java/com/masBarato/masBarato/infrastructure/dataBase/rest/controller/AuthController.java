package com.masBarato.masBarato.infrastructure.dataBase.rest.controller;

import com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.in.InLogin;
import com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.out.outAuth;
import com.masBarato.masBarato.infrastructure.dataBase.sql.adapter.AuthServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServices authServices;

    @PostMapping(value = "login")
    public ResponseEntity<outAuth> login(@RequestBody InLogin request) {

        return ResponseEntity.ok(authServices.login(request));
    }
}
