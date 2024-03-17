package com.example.springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.springboot.service.IAuthenticationService;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private IAuthenticationService authenticationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 檢查身份驗證
        String token = request.getHeader("Authorization");
        if (token == null || !authenticationService.isAuthenticated(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
