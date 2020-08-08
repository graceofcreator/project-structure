package com.gungun.project.controller;

import com.alibaba.fastjson.JSON;
import com.gungun.projects.entity.RequestParamRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 测试请求参数
 * @Author zhangjian
 * @Date 2020/7/13 11:04 下午
 * @Version 1.0
 * @Change
 */
@RestController
@Slf4j
public class RequestController {

    @RequestMapping(value = "/getRequestAndObjectParam",method = RequestMethod.GET)
    public void getRequestAndObjectParam(RequestParamRequest requestParamRequest){
       log.info(JSON.toJSONString(requestParamRequest));
    }


    @RequestMapping(value = "/getRequestAndParam",method = RequestMethod.GET)
    public void getRequestAndParam(String name,String address){
        log.info(name+"--"+address);
    }

    @RequestMapping(value = "/postRequestAndParam",method = RequestMethod.POST)
    public void postRequestAndParam(String name,String address){
        log.info(name+"--"+address);
    }

    @RequestMapping(value = "/postRequestAndObjectParam",method = RequestMethod.POST)
    public void postRequestAndObjectParam(RequestParamRequest requestParamRequest){
        log.info(JSON.toJSONString(requestParamRequest));
    }

    @RequestMapping(value = "/postRequestAndObjectBody",method = RequestMethod.POST)
    public void postRequestAndObjectbody(@RequestBody RequestParamRequest requestParamRequest){
        log.info(JSON.toJSONString(requestParamRequest));
    }
}
