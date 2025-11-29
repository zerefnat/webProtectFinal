package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.domain.repository.IUserRepositoryPort;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.mapper.UserMapper;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements IUserRepositoryPort {
    private final UserJpaRepository userJpaRepository;

    @Override
    public User findUserByUserId(Integer userId) {
        UserEntity userEntity= userJpaRepository.findUserByUserId(userId);
        return UserMapper.fromUserEntityToUser(userEntity);
    }

    @Override
    public User findUserByUserEmail(String email) {
        UserEntity userEntity = userJpaRepository.findUserBygmail(email);
        return UserMapper.fromUserEntityToUser(userEntity);
    }

    @Override
    public User findUserByUsername(String username) {
        UserEntity userEntity = userJpaRepository.findUserByUserName(username);
        return UserMapper.fromUserEntityToUser(userEntity);
    }

    @Override
    public boolean deleteUserByUserId(Integer userId) {
        userJpaRepository.deleteById(userId);
        return findUserByUserId(userId) == null;
    }

    @Override
    public Boolean newUser(User user) {
        UserEntity userEntity = UserMapper.fromUserToUserEntity(user);
        userJpaRepository.save(userEntity);
        return findUserByUserId(userEntity.getUserId()) != null;
    }

    @Override
    public Boolean updateUser(Integer userId, User user) {
      Optional<UserEntity > optionalUserEntity = Optional.ofNullable(userJpaRepository.findUserByUserId(userId));
        if(optionalUserEntity.isEmpty()) {
            return false;
        }
        UserEntity userEntity = optionalUserEntity.get();
        System.out.println(userEntity.toString());
        UserEntity updateUserEntity = UserMapper.fromUserToUserEntity(user);
        updateUserEntity.setUserId(userId);
        userJpaRepository.save(updateUserEntity);
        return true;
    }


}
