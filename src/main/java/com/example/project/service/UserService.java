package com.example.project.service;

import com.example.project.dto.mapper;
import com.example.project.dto.requestDto.UserRequestDto;
import com.example.project.dto.responseDto.UserResponseDto;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // Get user from database
        com.example.project.model.User userModel =  userRepository.findByEmail(userName);
        String userEmail =  userModel.getEmail(); //String.valueOf(User.builder().username(userModel.getEmail()));
        String password = userModel.getPassword(); //String.valueOf(User.builder().password(userModel.getPassword()));
        //
        return new User(userEmail, password, new ArrayList<>());
    }

    //@Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        com.example.project.model.User user = new com.example.project.model.User();
        user.setId((int)(Math.random()*(900-100+1)+100));
        user.setEmail(userRequestDto.getEmail());
        //user.setPassword(userRequestDto.getPassword());

        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        userRepository.save(user);
        return mapper.userToUserResponseDto(user);
    }








}
