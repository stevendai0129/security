package com.hb.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping(path = "/orders")
    public String orders(){
        JSONArray jsonArray = new JSONArray();
        JSONObject order1 = new JSONObject();
        order1.put("id",1);
        order1.put("amount",100);
        order1.put("customer","张三");
        order1.put("time","2024-02-05 13:22:22");

        JSONObject order2 = new JSONObject();
        order1.put("id",2);
        order1.put("amount",200);
        order1.put("customer","李四");
        order1.put("time","2024-02-05 15:22:22");

        JSONObject order3 = new JSONObject();
        order1.put("id",3);
        order1.put("amount",300);
        order1.put("customer","王五");
        order1.put("time","2024-02-05 16:22:22");

        jsonArray.add(order1);
        jsonArray.add(order2);
        jsonArray.add(order3);
        return jsonArray.toString();
    }
}
