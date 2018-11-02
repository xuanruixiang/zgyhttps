package com.shgbit.zgyhttps.controller;

import com.alibaba.fastjson.JSONObject;
import com.shgbit.zgyhttps.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public void querytest() {
        List<JSONObject> tasks=userMapper.queryAll();
        for(int i=0;i<tasks.size();i++){
            JSONObject taskObj= tasks.get(i);
            System.out.println(taskObj.toString());
           // System.out.println(getData(taskObj));
            System.out.println(postData(taskObj));

        }
    }

    public String getData(JSONObject taskObj){
        Map<String, String> map = (Map)taskObj;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://iexe.shgbitcloud.com/iexe/pub/performanceIndicator?court={court}&type={type}", String.class, map);
        return responseEntity.getBody();
    }


    public String postData(JSONObject taskObj){

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("https://www.shgbitcloud.com:5010/court/statistics ",taskObj, String.class);
        return responseEntity.getBody();
    }
}
