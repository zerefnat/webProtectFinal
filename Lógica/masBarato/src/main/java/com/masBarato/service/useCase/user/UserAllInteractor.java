package com.masBarato.masBarato.service.useCase.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.User;
import com.masBarato.masBarato.service.UserServices;

import java.util.List;
@RequiredArgsConstructor
@Component
public class UserAllInteractor implements IUserAllInteractor{
    private final UserServices userRepository;



    @Override
    public List<User> allUsers() {
        return userRepository.getAllUsers();
    }
}
