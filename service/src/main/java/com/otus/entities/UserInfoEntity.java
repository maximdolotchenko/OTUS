package com.otus.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MDolotchenko
 */
@Entity
@Table(name = "user_info")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoEntity {
    @Id
    private Long id;
    @Column
    private String avatarUri;
    @Column
    private String age;
}
