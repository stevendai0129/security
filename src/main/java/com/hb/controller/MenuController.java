package com.hb.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @GetMapping(path = "/menu")
    public String orders(){
        JSONArray jsonArray = new JSONArray();
        JSONObject m1 = new JSONObject();
        m1.put("code","Orders");
        m1.put("name","Orders");

        JSONObject m2 = new JSONObject();
        m1.put("code","Products");
        m1.put("name","Products");

        JSONObject m3 = new JSONObject();
        m1.put("code","Dashboard");
        m1.put("name","Dashboard");

        jsonArray.add(m1);
        jsonArray.add(m2);
        jsonArray.add(m3);
        return jsonArray.toString();
    }
}
