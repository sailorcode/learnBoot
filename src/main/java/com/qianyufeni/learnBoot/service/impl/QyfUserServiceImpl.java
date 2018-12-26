package com.qianyufeni.learnBoot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianyufeni.learnBoot.dao.QyfUserMapper;
import com.qianyufeni.learnBoot.entity.QyfUser;
import com.qianyufeni.learnBoot.service.QyfUserService;
import org.springframework.stereotype.Service;

@Service
public class QyfUserServiceImpl extends ServiceImpl<QyfUserMapper,QyfUser> implements QyfUserService {
}
