package com.gungun.projects.valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 校验请求参数
 * @param <T>
 */
@Component
@Slf4j
public class AnnotationValidator<T> {

    /** 创建validator对像 */
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
    /**
     * 根据分组校验 validation在验证时当多个参数同时出现校验异常时按照组的顺序返回
     * @param t
     * @param groups
     * @return
     */
    public ValidateResult validate(T t,Class<?>... groups){
        ValidateResult result = new ValidateResult();
        result.setResult(true);
        Set<ConstraintViolation<T>> set = VALIDATOR.validate(t,groups);
        for (ConstraintViolation constraintViolation : set) {
            result.setResult(false);
            result.setMessage(constraintViolation.getMessage());
            return result;
        }
        return result;
    }

    /**
     * 校验 validation在验证时当多个参数同时出现校验异常时返回的错误是随机的
     * @param t
     * @return
     */
    public ValidateResult validate(T t){
        ValidateResult result = new ValidateResult();
        result.setResult(true);
        Set<ConstraintViolation<T>> set = VALIDATOR.validate(t);
        for (ConstraintViolation constraintViolation : set) {
            result.setResult(false);
            result.setMessage(constraintViolation.getMessage());
            return result;
        }
        return result;
    }

}
