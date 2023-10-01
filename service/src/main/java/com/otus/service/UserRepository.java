package com.otus.service;

import com.otus.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MDolotchenko
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
