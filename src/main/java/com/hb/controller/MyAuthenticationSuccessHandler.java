package com.hb.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status","ok");
        jsonObject.put("msg","成功");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonObject.toString());

        Object credentials = authentication.getCredentials();
    }
}
