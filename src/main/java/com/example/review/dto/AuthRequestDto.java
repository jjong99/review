package com.example.review.dto;

import com.example.review.entity.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDto {
    private String username;
    private String password;
    private UserRoleEnum role;
}
