package com.liaojiexin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: CommonResult
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 10:02
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private static final Integer CODE_SUCCESS = 0;

    private static final Integer CODE_ERROR = -1;

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

    public static CommonResult ok(){
        return new CommonResult(CODE_SUCCESS,"操作成功",null);
    }

    public static CommonResult error(){
        return new CommonResult(CODE_ERROR,"操作失败",null);
    }
}
