package com.sho.blog_api.Service;

import com.sho.blog_api.Dtos.LoginDto;
import com.sho.blog_api.Dtos.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
