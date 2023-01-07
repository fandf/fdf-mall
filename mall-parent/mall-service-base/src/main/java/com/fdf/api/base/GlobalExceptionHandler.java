package com.fdf.api.base;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fandongfeng
 * @date 2023/1/7 18:23
 */
@ControllerAdvice(basePackages = "com.fdf.api.impl")
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> errorResult() {
        Map<String, Object> map = new HashMap<>(4);
        map.put("code", "500");
        map.put("msg", "系统出现错误");
        return map;
    }

}
