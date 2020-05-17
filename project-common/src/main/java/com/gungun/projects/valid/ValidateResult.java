package com.gungun.projects.valid;

import lombok.Data;

/**
 * validate的参数校验
 * 比如@notblank/@length注解
 */
@Data
public class ValidateResult {
    /**
     * 校验结果
     */
    private boolean result;

    /**
     * 校验失败的错误信息
     */
    private String message;
}
