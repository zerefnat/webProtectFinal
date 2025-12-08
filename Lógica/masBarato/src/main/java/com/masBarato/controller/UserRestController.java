package com.masBarato.masBarato.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masBarato.masBarato.dto.in.inUserDto;
import com.masBarato.masBarato.dto.out.outUserDto;
import com.masBarato.masBarato.model.classes.Rol;
import com.masBarato.masBarato.model.classes.User;
import com.masBarato.masBarato.service.useCase.rol.IRolFindInteractor;
import com.masBarato.masBarato.service.useCase.user.IUserAllInteractor;
import com.masBarato.masBarato.service.useCase.user.IUserDeleteInteractor;
import com.masBarato.masBarato.service.useCase.user.IUserFindInteractor;
import com.masBarato.masBarato.service.useCase.user.IUserPostInteractor;
import com.masBarato.masBarato.service.useCase.user.IUserPutInteractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    private final IUserFindInteractor userFindInteractor;
    private final IUserDeleteInteractor userDeleteInteractor;
    private final IUserPostInteractor userPostInteractor;
    private final IUserPutInteractor userPutInteractor;
    private final IUserAllInteractor userAllInteractor;
    private final IRolFindInteractor rolFindInteractor;

    @GetMapping("/{userId}")
    public ResponseEntity<outUserDto> findUserByUserId(@PathVariable String userId) {
        Optional<User> userOptional = Optional.ofNullable(userFindInteractor.findUserByUserId(userId));
        if(userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = userOptional.get();
        Rol rol = rolFindInteractor.findRolByRoleId(user.getRoles());
        outUserDto userDto=outUserDto.fromUserToUserDto(user,rol.getRolName());
        return ResponseEntity.ok(userDto);
    }


    @GetMapping("/gmail/{email}")
    public ResponseEntity<outUserDto > findUserByEmail(@PathVariable String email) {
        Optional<User> userOptional = Optional.ofNullable(userFindInteractor.findUserByEmail(email));
        if(userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = userOptional.get();
        Rol rol = rolFindInteractor.findRolByRoleId(user.getRoles());
        outUserDto userDto=outUserDto.fromUserToUserDto(user,rol.getRolName());
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<outUserDto>> allUsers() {
        List<User> users = userAllInteractor.allUsers();
        if(users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<outUserDto> usersDto = new ArrayList<>();
        for(User user : users) {
            Rol rol = rolFindInteractor.findRolByRoleId(user.getRoles());
            usersDto.add(outUserDto.fromUserToUserDto(user,rol.getRolName()));
        }
        return ResponseEntity.ok(usersDto);
    }

    @GetMapping("/fkUserId/{fkUserId}")
    public ResponseEntity<List<outUserDto>> findUserByFkUserId(@PathVariable String fkUserId) {
        List<User> users = userFindInteractor.findUserByFkUserId(fkUserId);
        if(users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<outUserDto> usersDto = new ArrayList<>();
        for(User user : users) {
            Rol rol = rolFindInteractor.findRolByRoleId(user.getRoles());
            usersDto.add(outUserDto.fromUserToUserDto(user,rol.getRolName()));
        }
        return ResponseEntity.ok(usersDto);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUserByUserId(@PathVariable String userId) {
        return  userDeleteInteractor.deleteUserByUserId(userId);
    }
    @PostMapping("")
    public boolean createUser(@RequestBody inUserDto userDto) {
        User user = inUserDto.fromUserDtoToUser(userDto);
        return userPostInteractor.newUser(user);
    }

    @PutMapping("/{userId}")
    public boolean updateUser(@PathVariable String userId, @RequestBody inUserDto userDto) {
        User user = inUserDto.fromUserDtoToUser(userDto);
        return userPutInteractor.updateUser(userId,user);
    }
}
