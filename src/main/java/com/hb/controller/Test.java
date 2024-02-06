package com.hb.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String nimda = bCryptPasswordEncoder.encode("nimda");
        System.out.println(nimda);
    }
}
