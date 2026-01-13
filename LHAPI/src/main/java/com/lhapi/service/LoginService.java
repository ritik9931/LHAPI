package com.lhapi.service;

import com.lhapi.dto.request.LoginRequest;
import com.lhapi.dto.response.LoginResponse;

public interface LoginService {
	
	LoginResponse login(LoginRequest request);

}
