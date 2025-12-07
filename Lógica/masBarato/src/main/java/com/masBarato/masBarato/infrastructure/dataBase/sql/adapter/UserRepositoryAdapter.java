package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;

import com.masBarato.masBarato.domain.model.User;
import com.masBarato.masBarato.domain.repository.IUserDeleteRepositoryPort;
import com.masBarato.masBarato.domain.repository.IUserRepositoryPort;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserDeletedEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.mapper.UserMapper;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.UserDeleteJpaRepository;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements IUserRepositoryPort, IUserDeleteRepositoryPort {
    private final UserJpaRepository userJpaRepository;
    private final UserDeleteJpaRepository userDeleteJpaRepository;


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
    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userJpaRepository.findAll();
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            User user = UserMapper.fromUserEntityToUser(userEntity);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findUserByFkUserId(Integer fkUserId) {
        List<UserEntity> userEntities= userJpaRepository.findAllByFkUserId_UserId(fkUserId);
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            User user = UserMapper.fromUserEntityToUser(userEntity);
            users.add(user);
        }
        return users;
    }

    @Override
    public boolean deleteUserByUserId(Integer userId) {
        UserEntity userEntity = userJpaRepository.findUserByUserId(userId);
        User user = UserMapper.fromUserEntityToUser(userEntity);
        if (!addUserDelete(user))
            return false;
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
        UserEntity updateUserEntity = UserMapper.fromUserToUserEntity(user);
        updateUserEntity.setUserId(userId);
        userJpaRepository.save(updateUserEntity);
        return true;
    }

    @Override
    public boolean addUserDelete(User userDeleted) {
        UserDeletedEntity userDeleteEntity = UserMapper.fromUserToUserDeleteEntity(userDeleted);
        userDeleteJpaRepository.save(userDeleteEntity);
        return findUserByUserDeleteId(userDeleteEntity.getUserId())!=null;
    }

    @Override
    public User findUserByUserDeleteId(Integer userId) {
        UserDeletedEntity userDeleted = userDeleteJpaRepository.findUserByUserId(userId);
        return UserMapper.fromUserDeleteEntityToUser(userDeleted);
    }
}
