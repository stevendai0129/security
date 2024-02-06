package com.hb.controller;

import com.alibaba.fastjson2.JSON;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        System.out.println("执行到MyUsernamePasswordAuthenticationFilter");
//        return super.attemptAuthentication(request, response);

        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: "
                            + request.getMethod());
        }

        // 加密密码(根据“密码{用户名})进行加密
        // String sh1Password = password + "{" + username + "}";
        // PasswordEncoder passwordEncoder = new
        // StandardPasswordEncoderForSha1();
        // String result = passwordEncoder.encode(sh1Password);
        // UserInfo userDetails = (UserInfo)
        // userDetailsService.loadUserByUsername(username);

        Map<String, String> loginData = new HashMap<>();
        try {
            loginData = JSON.parseObject(request.getInputStream(),Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //这里需要先对用户名进行验证，否则只要密码正确就都可以进行登录

        String username = loginData.get(USERNAME);
        String password = loginData.get(PASSWORD);

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        Object obj = request.getParameter(PASSWORD);
        return null == obj ? "" : obj.toString();
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        Object obj = request.getParameter(USERNAME);
        return null == obj ? "" : obj.toString().trim().toLowerCase();
    }
}
