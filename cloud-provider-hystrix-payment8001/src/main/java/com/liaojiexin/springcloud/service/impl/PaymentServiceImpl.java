package com.liaojiexin.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.liaojiexin.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PaymentServiceImpl
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 10:29
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String payment_ok(Integer id) {
        int i=10/0;
        String result="线程池："+Thread.currentThread().getName()+";接口payment_ok,id:"+id;
        System.out.println(result);
        return result;
    }

    /**
     * 超时会导致服务降级，详细看脑图服务降级
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "pyamentTimeoutHandler",commandProperties = {
            //设置超时时间为1000毫秒时，就会调用pyamentTimeoutHandler方法来做服务降级
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public String payment_timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
            //注意这里也会找出服务降级，尽管这里@HystrixProperty没做修改，
            // 因为这里底层代码里面有一些异常配置，找不到超时的异常会找别的异常
            //int i=10/0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result="线程池："+Thread.currentThread().getName()+";接口payment_timeout,id"+id;
        System.out.println(result);
        return result;
    }

    //这里payment_timeout方法服务降级后的兜底方法，这里要注意该方法要和调用这个方法的参数相同，
    // 即payment_outtime有一个(Integer id),pyamentTimeoutHandler也要和他一样
    public String pyamentTimeoutHandler(Integer id){
        String result="线程池："+Thread.currentThread().getName()+";8001服务接口调用繁忙，请稍后再试";
        return result;
    }

    //=========服务熔新
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            //发送10次请求（enabled），且60%的请求（errorThresholdPercentage）
            // ，即6次请求降级，就会触发熔断，在拒绝请求10秒（sleepwindowInMilliseconds）后在尝试请求并决定回路是否继续打开
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            //设置在一个滚动窗口中，打开断路器的最少请求数。，这里配合errorThresholdPercentage使用，如果没有达到请求次数，即errorThresholdPercentage也不会生效
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //默认为5秒，设置在回路被打开，拒绝请求到再次尝试请求并决定回路是否继续打开的时间。
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //设置打开回路并启动回退逻辑的错误比率。
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能负数,请稍后再试,id:" + id;
    }
}
