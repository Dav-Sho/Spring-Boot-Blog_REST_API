package com.sho.blog_api.Service;

import com.sho.blog_api.Dtos.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
