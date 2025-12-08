package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.UserDeletedEntity;

public interface UserDeleteJpaRepository extends JpaRepository<UserDeletedEntity, String> {
    UserDeletedEntity findUserByUserId(String userId);
}
