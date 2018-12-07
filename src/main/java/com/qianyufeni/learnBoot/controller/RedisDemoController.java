package com.qianyufeni.learnBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redis")
public class RedisDemoController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping(value = "setstring")
    public void testRedisSetValue(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    @GetMapping(value = "getstring")
    public void testRedisGetValue(String key){
        redisTemplate.opsForValue().get(key);
    }
}
