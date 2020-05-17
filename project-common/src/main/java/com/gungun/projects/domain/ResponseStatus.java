package com.gungun.projects.domain;

public class ResponseStatus {

    /** 成功 */
    public static final Integer OK = 200;

    /** 服务端内部错误，用与全局异常未try catch的 */
    public static final Integer INTERNAL_ERR = 500;
}
