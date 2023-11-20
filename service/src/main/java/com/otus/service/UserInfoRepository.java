package com.otus.service;

import com.otus.entities.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author MDolotchenko
 */
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE UserInfoEntity SET avatarUri = :avatar_uri, age = :age WHERE id = :id")
    Integer updateMe(@Param("avatar_uri") String avatarUri, @Param("age") String age, @Param("id") Long id);
}
