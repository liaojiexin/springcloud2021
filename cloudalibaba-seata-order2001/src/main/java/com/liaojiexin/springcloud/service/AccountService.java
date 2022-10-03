package com.liaojiexin.springcloud.service;

import com.liaojiexin.springcloud.entity.Account;
import com.liaojiexin.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName AccountService
 * @Description TODO
 * @Author liao
 * @Date 10:36 下午 2022/10/2
 **/
@Service
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @RequestMapping(value = "/account/update")
    CommonResult update(Account account);
}
