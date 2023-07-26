package com.example.review.service;

import com.example.review.dto.AuthRequestDto;
import com.example.review.entity.User;
import com.example.review.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    public void signup(AuthRequestDto authRequestDto) {
        String username = authRequestDto.getUsername();
        String password = passwordEncoder.encode(authRequestDto.getPassword());

        if(userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }

        User user = new User(username, password);
        userRepository.save(user);
    }

    public void login(AuthRequestDto authRequestDto) {
        String username = authRequestDto.getUsername();
        String password = authRequestDto.getPassword();

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw  new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
