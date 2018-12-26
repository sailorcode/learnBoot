package com.qianyufeni.learnBoot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class QyfUser {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
