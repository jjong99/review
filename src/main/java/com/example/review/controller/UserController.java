package com.example.review.controller;

import com.example.review.dto.AuthRequestDto;
import com.example.review.jwt.JwtUtil;
import com.example.review.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    JwtUtil jwtUtil;

    UserService userService;

    @PostMapping("/signup")
    void signup(@RequestBody AuthRequestDto authRequestDto) {
        userService.signup(authRequestDto);
    }

    @PostMapping("/login")
    void login(@RequestBody AuthRequestDto authRequestDto, HttpServletResponse response) {
        userService.login(authRequestDto);
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(authRequestDto.getUsername()));
    }


}
