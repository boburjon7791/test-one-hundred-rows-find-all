package com.example.test_one_hundred_rows_find_all.controller;

import com.example.test_one_hundred_rows_find_all.models.dto.UserDto;
import com.example.test_one_hundred_rows_find_all.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(user -> new UserDto(user.getId(), user.getFullName())).toList();
    }
}
