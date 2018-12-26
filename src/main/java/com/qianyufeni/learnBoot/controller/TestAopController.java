package com.qianyufeni.learnBoot.controller;

import com.qianyufeni.learnBoot.annotation.ResourceLog;
import com.qianyufeni.learnBoot.dao.QyfUserMapper;
import com.qianyufeni.learnBoot.entity.QyfUser;
import com.qianyufeni.learnBoot.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestAopController {
    @GetMapping("/aop")
    @ResourceLog(type = "vm", action = "create")
    public ResponseData operationLog(int id, String name){
        ResponseData res = new ResponseData();
        return res;
    }

    @GetMapping("/aop2")
    public ResponseData operationLog2(String id, String name){
        ResponseData res = new ResponseData();
        return res;
    }
}
