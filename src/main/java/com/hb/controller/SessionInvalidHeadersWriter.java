package com.hb.controller;

import org.springframework.security.web.header.Header;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SessionInvalidHeadersWriter extends StaticHeadersWriter {
    public SessionInvalidHeadersWriter(List<Header> headers) {
        super(headers);
    }

    @Override
    public void writeHeaders(HttpServletRequest request, HttpServletResponse response) {
        super.writeHeaders(request, response);

        response.setHeader("Access-Control-Allow-Credentials", "true"); //是否支持cookie跨域
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
    }
}
