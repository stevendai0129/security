package com.hb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResourceController {
    @GetMapping(path = "/resource")
    public String getResource(){
        System.out.println("获取资源");
        return "获取资源";
    }
}
