package com.lhapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhapi.dto.request.LoginRequest;
import com.lhapi.dto.response.LoginResponse;
import com.lhapi.entity.User;
import com.lhapi.reposioory.UserRepository;
import com.lhapi.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepo.findByUserId(request.getUserId())
                .orElse(null);

        if (user == null) {
            return new LoginResponse(false, "Invalid User ID", null);
        }

        if (!request.getPassword().equals(user.getPassword())) {
            return new LoginResponse(false, "Invalid Password", null);
        }

        return new LoginResponse(true, "Login successful", user.getUserId());
    }
}
