package com.qianyufeni.learnBoot.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianyufeni.learnBoot.entity.QyfUser;
import com.qianyufeni.learnBoot.service.QyfUserService;
import com.qianyufeni.learnBoot.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qyfuser")
public class TestMybatisPlusController {
    @Autowired
    private QyfUserService qyfUserService;
    @GetMapping("/")
    public ResponseData<IPage<QyfUser>> queryByPage(){
        ResponseData<IPage<QyfUser>> resp = new ResponseData<>();
        IPage<QyfUser> iPage = qyfUserService.page(new Page<QyfUser>(1,3));
        resp.setStatus("200");
        resp.setData(iPage);
        return resp;
    }


}
