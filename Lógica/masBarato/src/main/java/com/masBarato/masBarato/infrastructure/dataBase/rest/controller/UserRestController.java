package com.masBarato.masBarato.infrastructure.dataBase.rest.controller;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.UserDto;
import com.masBarato.masBarato.useCase.User.IUserDeleteInteractor;
import com.masBarato.masBarato.useCase.User.IUserFindInteractor;
import com.masBarato.masBarato.useCase.User.IUserPostInteractor;
import com.masBarato.masBarato.useCase.User.IUserPutInteractor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    private final IUserFindInteractor userFindInteractor;
    private final IUserDeleteInteractor userDeleteInteractor;
    private final IUserPostInteractor userPostInteractor;
    private final IUserPutInteractor userPutInteractor;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto > findUserByUserId(@PathVariable Integer userId) {
        Optional<User> userOptional = Optional.ofNullable(userFindInteractor.findUserByUserId(userId));
        if(userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = userOptional.get();
        UserDto userDto=UserDto.fromUserToUserDto(user);
        return ResponseEntity.ok(userDto);
    }


    @GetMapping("/gmail/{email}")
    public ResponseEntity<UserDto > findUserByEmail(@PathVariable String email) {
        Optional<User> userOptional = Optional.ofNullable(userFindInteractor.findUserByEmail(email));
        if(userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = userOptional.get();
        UserDto userDto=UserDto.fromUserToUserDto(user);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/userName/{userName}")
    public ResponseEntity<UserDto > findUserByUserName(@PathVariable String userName) {
        Optional<User> userOptional = Optional.ofNullable(userFindInteractor.findUserByUsername(userName));
        if(userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = userOptional.get();
        UserDto userDto=UserDto.fromUserToUserDto(user);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUserByUserId(@PathVariable Integer userId) {
        return  userDeleteInteractor.deleteUserByUserId(userId);
    }
    @PostMapping("")
    public boolean createUser(@RequestBody UserDto userDto) {
        User user = UserDto.fromUserDtoToUser(userDto);
        return userPostInteractor.newUser(user);
    }

    @PutMapping("/{userId}")
    public boolean updateUser(@PathVariable Integer userId, @RequestBody UserDto userDto) {
        User user = UserDto.fromUserDtoToUser(userDto);
        return userPutInteractor.updateUser(userId,user);
    }



}
