package com.liaojiexin.springcloud.service;

import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Storage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName StorageService
 * @Description TODO
 * @Author liao
 * @Date 10:36 下午 2022/10/2
 **/
@Service
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @RequestMapping(value = "/storage/update")
    CommonResult update(Storage storage);
}
