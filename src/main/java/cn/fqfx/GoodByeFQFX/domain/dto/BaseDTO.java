package cn.fqfx.GoodByeFQFX.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Base DTO
 */
@Data
@AllArgsConstructor
public class BaseDTO {

    public static BaseDTO OK = new BaseDTO();

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

    public BaseDTO() {
        this(0, true, "");
    }
}
