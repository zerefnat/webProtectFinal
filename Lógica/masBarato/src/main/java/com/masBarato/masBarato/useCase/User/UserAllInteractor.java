package com.masBarato.masBarato.useCase.User;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.domain.repository.IUserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@RequiredArgsConstructor
@Component
public class UserAllInteractor implements IUserAllInteractor{
    private final IUserRepositoryPort userRepository;



    @Override
    public List<User> allUsers() {
        return userRepository.getAllUsers();
    }
}
