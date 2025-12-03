package com.masBarato.masBarato.infrastructure.dataBase.sql.repository;

import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserDeletedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDeleteJpaRepository extends JpaRepository<UserDeletedEntity, Integer> {
    UserDeletedEntity findUserByUserId(Integer userId);
}
