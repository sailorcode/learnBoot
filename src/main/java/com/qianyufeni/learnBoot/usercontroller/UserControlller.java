package com.qianyufeni.learnBoot.usercontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserControlller {

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,headers="a=a",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String login(MultiValueMap map){
        map.toString();
        return "success";
    }

}
