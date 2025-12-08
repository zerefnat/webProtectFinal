package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.UserEntity;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
    UserEntity findUserByUserId(String userId);
    UserEntity findUserBygmail(String email);
    List<UserEntity> findAllByFkUserId_UserId(String fkUserId);
}
