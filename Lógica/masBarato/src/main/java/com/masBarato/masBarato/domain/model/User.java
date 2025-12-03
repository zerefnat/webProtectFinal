package com.masBarato.masBarato.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private Integer userId;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String gmail;
    private String userName;
    private String password;
    private Integer roles;
    private Integer fk_userId;
}
