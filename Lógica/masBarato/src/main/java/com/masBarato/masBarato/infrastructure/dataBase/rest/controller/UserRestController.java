package com.masBarato.masBarato.infrastructure.dataBase.rest.controller;

import com.masBarato.masBarato.domain.model.Rol;
import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.in.inUserDto;
import com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.out.outUserDto;
import com.masBarato.masBarato.useCase.Rol.IRolFindInteractor;
import com.masBarato.masBarato.useCase.User.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<outUserDto> findUserByUserId(@PathVariable Integer userId) {
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

    @GetMapping("/userName/{userName}")
    public ResponseEntity<outUserDto > findUserByUserName(@PathVariable String userName) {
        Optional<User> userOptional = Optional.ofNullable(userFindInteractor.findUserByUsername(userName));
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
    public ResponseEntity<List<outUserDto>> findUserByFkUserId(@PathVariable Integer fkUserId) {
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
    public boolean deleteUserByUserId(@PathVariable Integer userId) {
        return  userDeleteInteractor.deleteUserByUserId(userId);
    }
    @PostMapping("")
    public boolean createUser(@RequestBody inUserDto userDto) {
        User user = inUserDto.fromUserDtoToUser(userDto);
        return userPostInteractor.newUser(user);
    }

    @PutMapping("/{userId}")
    public boolean updateUser(@PathVariable Integer userId, @RequestBody inUserDto userDto) {
        User user = inUserDto.fromUserDtoToUser(userDto);
        return userPutInteractor.updateUser(userId,user);
    }




}
