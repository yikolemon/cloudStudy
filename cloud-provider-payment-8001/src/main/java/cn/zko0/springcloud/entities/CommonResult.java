package cn.zko0.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author duanfuqiang
 * @date 2023/1/11 15:40
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;

    private T data;


    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
