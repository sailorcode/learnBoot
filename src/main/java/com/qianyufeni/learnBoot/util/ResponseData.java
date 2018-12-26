
package com.qianyufeni.learnBoot.util;

import lombok.Data;

@Data
public class ResponseData<T>
{
    private String status;

    private String errorCode;

    private String detail;

    private T data;

    public ResponseData()
    {
        super();
    }

    public ResponseData(String detail)
    {
        super();
        this.detail = detail;
    }

}
