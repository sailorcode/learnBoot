package com.qianyufeni.learnBoot.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1014720383054957370L;
    @NotNull
    private String userName;
    @NotNull
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
