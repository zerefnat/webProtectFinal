package com.masBarato.masBarato.infrastructure.dataBase.sql.repository;

import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findUserByUserId(Integer userId);
    UserEntity findUserBygmail(String email);
    UserEntity findUserByUserName(String username);
}
