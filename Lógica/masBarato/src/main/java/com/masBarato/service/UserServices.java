package com.masBarato.masBarato.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.UserMapper;
import com.masBarato.masBarato.model.classes.User;
import com.masBarato.masBarato.model.entity.UserDeletedEntity;
import com.masBarato.masBarato.model.entity.UserEntity;
import com.masBarato.masBarato.repository.UserDeleteJpaRepository;
import com.masBarato.masBarato.repository.UserJpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserServices {
    private final UserJpaRepository userJpaRepository;
    private final UserDeleteJpaRepository userDeleteJpaRepository;

    public User findUserByUserId(String userId) {
        UserEntity userEntity= userJpaRepository.findUserByUserId(userId);
        return UserMapper.fromUserEntityToUser(userEntity);
    }

    public User findUserByUserEmail(String email) {
        UserEntity userEntity = userJpaRepository.findUserBygmail(email);
        return UserMapper.fromUserEntityToUser(userEntity);
    }

    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userJpaRepository.findAll();
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            User user = UserMapper.fromUserEntityToUser(userEntity);
            users.add(user);
        }
        return users;
    }

    public List<User> findUserByFkUserId(String fkUserId) {
        List<UserEntity> userEntities= userJpaRepository.findAllByFkUserId_UserId(fkUserId);
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            User user = UserMapper.fromUserEntityToUser(userEntity);
            users.add(user);
        }
        return users;
    }

    public boolean deleteUserByUserId(String userId) {
        UserEntity userEntity = userJpaRepository.findUserByUserId(userId);
        User user = UserMapper.fromUserEntityToUser(userEntity);
        if (!addUserDelete(user))
            return false;
        userJpaRepository.deleteById(userId);
        return findUserByUserId(userId) == null;
    }

    public Boolean newUser(User user) {
        UserEntity userEntity = UserMapper.fromUserToUserEntity(user);
        userJpaRepository.save(userEntity);
        return findUserByUserId(userEntity.getUserId()) != null;
    }

    public Boolean updateUser(String userId, User user) {
      Optional<UserEntity > optionalUserEntity = Optional.ofNullable(userJpaRepository.findUserByUserId(userId));
        if(optionalUserEntity.isEmpty()) {
            return false;
        }
        UserEntity userEntity = optionalUserEntity.get();
        UserEntity updateUserEntity = UserMapper.fromUserToUserEntity(user);
        updateUserEntity.setUserId(userId);
        userJpaRepository.save(updateUserEntity);
        return true;
    }

    public boolean addUserDelete(User userDeleted) {
        UserDeletedEntity userDeleteEntity = UserMapper.fromUserToUserDeleteEntity(userDeleted);
        userDeleteJpaRepository.save(userDeleteEntity);
        return findUserByUserDeleteId(userDeleteEntity.getUserId())!=null;
    }

    public User findUserByUserDeleteId(String userId) {
        UserDeletedEntity userDeleted = userDeleteJpaRepository.findUserByUserId(userId);
        return UserMapper.fromUserDeleteEntityToUser(userDeleted);
    }
}