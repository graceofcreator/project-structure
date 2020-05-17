package com.gungun.projects.domain;

import lombok.Data;

@Data
public class RestResponse<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /** 无参的构造方法 */
    public RestResponse (){

    }

    /**  有参构造方法 */
    public RestResponse (Integer code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /** success start */
    public RestResponse<T> success(){
        this.code = ResponseStatus.OK;
        this.message = ResponseMessage.OK;
        return this;
    }

    public RestResponse<T> success(String message){
        this.code = ResponseStatus.OK;
        this.message = message;
        return this;
    }

    public RestResponse<T> success(String message,T data){
        this.code = ResponseStatus.OK;
        this.message = message;
        this.data = data;
        return this;
    }
    /** success end */

    /** error start */
    public RestResponse<T> error(){
        this.code = ResponseStatus.INTERNAL_ERR;
        this.message = ResponseMessage.INTERNAL_ERR;
        return this;
    }

    public RestResponse<T> error(String message){
        this.code = ResponseStatus.INTERNAL_ERR;
        this.message = message;
        return this;
    }

    public RestResponse<T> error(String message,T data){
        this.code = ResponseStatus.INTERNAL_ERR;
        this.message = message;
        this.data = data;
        return this;
    }

    /** error end */

}

