package com.masBarato.masBarato.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private String userId;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String gmail;
    private String password;
    private Integer roles;
    private String fk_userId;
}
