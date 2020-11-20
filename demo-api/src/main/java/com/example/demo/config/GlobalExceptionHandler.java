package com.example.demo.config;

import com.example.demo.common.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;

/**
 * @author bruce
 * @date 2020/11/19 16:17
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse bindExceptionHandler(BindException exception) {
        FieldError error = exception.getFieldError();
        String message = String.format("errorField: %s, errorMessage: %s", error.getField(), error.getDefaultMessage());
        log.warn("BindException拦截器：【" + message + "】");
        return new BaseResponse(-1, message, null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().get(0);
        log.warn("MethodArgumentNotValidException拦截器：【" + objectError.getDefaultMessage() + "】");
        return new BaseResponse(-1, objectError.getDefaultMessage(), null);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse throwableHandle(Throwable ex) {
        log.error("Throwable拦截器：【" + ex.getMessage() + "】", ex);
        return new BaseResponse<>(0, ex.getMessage(), null);
    }

    @ExceptionHandler(AuthException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse authHandle(AuthException ex) {
        log.error("Throwable拦截器：【" + ex.getMessage() + "】", ex);
        return new BaseResponse<>(0, ex.getMessage(), null);
    }

}
