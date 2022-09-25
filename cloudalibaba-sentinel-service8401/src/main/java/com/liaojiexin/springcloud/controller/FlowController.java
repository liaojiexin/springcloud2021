package com.liaojiexin.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FlowController
 * @Description TODO
 * @Author liao
 * @Date 9:43 下午 2022/9/24
 **/
@RestController
public class FlowController {

    @GetMapping("/testa")
    public String testa(){
        System.out.println("测试测试");
        int i=10/0;
        return "----a";
    }

    @GetMapping("/testb")
    public String testb(){
        return "----b";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler="deal_testHotkey") //热点规则，value可以填任何，唯一即可
    public String testHotkey(@RequestParam(value="p1", required = false) String p1,
                             @RequestParam(value="p2",required = false) String p2){
        return "------testHotKey";
    }
    //testHostkey触发热点规则时，会执行deal_testHotkey方法
    public String deal_testHotkey(String p1, String p2, BlockException blockException){
        //sentinel的默认提示都为Blocked by Sentinel (flow limiting)，这里我们改成下面return的提示
        return  "------deal_testHotkey，testHotKey执行失败";
    }

}
