package com.qianyufeni.learnBoot.service.impl;

import com.qianyufeni.learnBoot.constant.RequestExceptionEnum;
import com.qianyufeni.learnBoot.exception.BadRequestException;
import com.qianyufeni.learnBoot.service.TestExceptionService;
import org.springframework.stereotype.Service;

@Service
public class TestExceptionServiceImpl implements TestExceptionService {
    @Override
    public void throwExceptionTest() {
        //经测试,service层的异常如果未捕获也会进"/error"请求
        throw new BadRequestException(RequestExceptionEnum.base.getCode(),RequestExceptionEnum.base.getMessage());
    }
}
