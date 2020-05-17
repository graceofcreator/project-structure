package com.gungun.projects.exception;

import com.gungun.projects.domain.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 全局异常处理器 如果加载到顶级异常 Exception 的捕获方法，那么后续加载的Exception的子类就会失效
 */
@RestControllerAdvice
@Component
@Slf4j
public class GobalExceptionHandler {


    /**
     * 参数校验失败处理
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestResponse<String> paramInvalid(HttpServletRequest request,MethodArgumentNotValidException ex){
        log.error("调用接口："+request.getRequestURL()+"出错，异常：",ex);
        RestResponse<String> restResponse = new RestResponse();
        BindingResult bindingResult = ex.getBindingResult();
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            StringBuffer errorMessageBuffer = new StringBuffer();
            allErrors.forEach(e->{
                FieldError fieldError = (FieldError) e;
                errorMessageBuffer.append(fieldError.getDefaultMessage()).append(",");
            });
            if(errorMessageBuffer.length() != 0){
                errorMessageBuffer.deleteCharAt(errorMessageBuffer.length() -1);
            }
            return restResponse.error(errorMessageBuffer.toString());
        }
        return restResponse.error();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public RestResponse<String> requestInvalid(HttpServletRequest request,HttpMessageNotReadableException ex){
        log.error("调用接口："+request.getRequestURL()+"出错，异常：",ex);
        RestResponse<String> restResponse = new RestResponse<>();
        restResponse.setCode(404);
        restResponse.setMessage("请求输入参数格式不正确");
        return restResponse;
    }

    /**
     * 处理一些没有被try catch捕获的异常及一些throws抛出的异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public RestResponse<String> defaultErrorHandle(HttpServletRequest request,Exception ex){
        log.error("调用接口："+request.getRequestURL()+"出错，异常：",ex);
        RestResponse<String> restResponse = new RestResponse();
        return restResponse.error();
    }

}
