package com.example.webframework.user;

import com.example.webframework.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
//@SQLRestriction("deleted = false")
public class UserAccount extends BaseEntity {
    @Column(nullable = false, length = 100)
    private String email;

    @Setter
    @Column(name = "password_hash", nullable = false, length = 100)
    private String passwordHash;

    @Setter
    @Column(nullable = false, length = 100)
    private String nickname;

    public UserAccount(String email, String passwordHash, String nickname){
        this.email = email;
        this.passwordHash =  passwordHash;
        this.nickname = nickname;
    }


}
