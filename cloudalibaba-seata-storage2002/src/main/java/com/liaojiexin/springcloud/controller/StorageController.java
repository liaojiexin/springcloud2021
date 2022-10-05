package com.liaojiexin.springcloud.controller;

import com.liaojiexin.springcloud.dao.StorageMapper;
import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName StorageController
 * @Description TODO
 * @Author liao
 * @Date 10:47 下午 2022/10/2
 **/
@RestController
public class StorageController {

    @Autowired
    private StorageMapper storageMapper;

    @RequestMapping(value = "/storage/update")
    public CommonResult update(@RequestBody Storage storage){
        Integer id=storage.getId();
        Integer count=storage.getCount();
        storage=storageMapper.selectByPrimaryKey(id);
        storage.setCount(storage.getCount()-count);
        storageMapper.updateByPrimaryKeySelective(storage);
        return CommonResult.ok();
    }
}
