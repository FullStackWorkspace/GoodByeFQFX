package cn.fqfx.GoodByeFQFX.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Base DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO <T> {
    private static final String DEFAULT_SUCCESS_MSG = "成功";
    private static final String DEFAULT_ERROR_MSG = "失败";

    /**
     * 错误码
     */
    protected Integer code;

    /**
     * 是否成功
     */
    protected Boolean success;

    /**
     * 附带信息
     */
    protected String msg;

    /**
     * 附加实体
     */
    protected T data;

    public static <T> BaseDTO<T> ok(String msg, T t){
        return new BaseDTO<>(0, true, msg, t);
    }

    public static <T> BaseDTO<T> ok(T t){
        return BaseDTO.ok(DEFAULT_SUCCESS_MSG, t);
    }

    public static <T> BaseDTO<T> ok() {
        return BaseDTO.ok(null);
    }

    public static <T> BaseDTO<T> error(Integer code, String msg, T t) {
        return new BaseDTO<>(code, false, msg, t);
    }

    public static <T> BaseDTO<T> error(Integer code, String msg) {
        return BaseDTO.error(code, msg, null);
    }

    public static <T> BaseDTO<T> error(Integer code) {
        return BaseDTO.error(code, DEFAULT_ERROR_MSG, null);
    }
}
