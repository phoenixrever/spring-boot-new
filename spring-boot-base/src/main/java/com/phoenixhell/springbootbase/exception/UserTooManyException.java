package com.phoenixhell.springbootbase.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  自定义异常exception
 */

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException{

    public UserTooManyException() {
    }

    public UserTooManyException(String message) {
        super(message);
    }
}
