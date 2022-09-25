package com.liaojiexin.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName CustomerBlockHandler
 * @Description TODO
 * @Author liao
 * @Date 10:16 下午 2022/9/25
 **/
public class CustomerBlockHandler {

    public static String handlerException(BlockException exception) {
        return "失败，按客戶自定义处理异常";
    }
}
