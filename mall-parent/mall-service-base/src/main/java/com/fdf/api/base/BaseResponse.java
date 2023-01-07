package com.fdf.api.base;

import com.fdf.api.constants.Constants;
import lombok.Data;

/**
 * @author fandongfeng
 * @date 2023/1/7 17:59
 */
@Data
public class BaseResponse<T> {

    private Integer code;
    private String msg;
    private T date;

    public BaseResponse(Integer code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    public static <T> BaseResponse<T> fail(String msg) {
        return setResult(Constants.RESULT_FAIL, msg, null);
    }

    public static <T> BaseResponse<T> fail(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    public static <T> BaseResponse<T> success() {
        return setResult(Constants.RESULT_OK, Constants.RESULT_OK_VALUE, null);
    }

    public static <T> BaseResponse<T> success(T data) {
        return setResult(Constants.RESULT_OK, Constants.RESULT_OK_VALUE, data);
    }

    public static <T> BaseResponse<T> setResult(Integer code, String msg, T data) {
        return new BaseResponse<>(code, msg, data);
    }


}
