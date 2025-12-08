package com.masBarato.masBarato.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masBarato.masBarato.dto.in.InLogin;
import com.masBarato.masBarato.dto.out.outAuth;
import com.masBarato.masBarato.service.AuthServices;

import lombok.RequiredArgsConstructor;

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
