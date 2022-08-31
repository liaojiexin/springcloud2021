package com.liaojiexin.springcloud.service.impl;

import com.liaojiexin.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
}
