package com.liaojiexin.springcloud.controller;

import com.liaojiexin.springcloud.dao.AccountMapper;
import com.liaojiexin.springcloud.entity.Account;
import com.liaojiexin.springcloud.entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AccountController
 * @Description TODO
 * @Author liao
 * @Date 9:21 上午 2022/10/3
 **/
@RestController
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping(value = "/account/update")
    public CommonResult update(@RequestBody Account account){
        Integer id=account.getId();
        Integer money=account.getMoney();
        String userId = account.getUserId();
        account=accountMapper.selectByPrimaryKey(id);
        account.setMoney(account.getMoney()-money);
        accountMapper.updateByPrimaryKeySelective(account);
        return CommonResult.ok();
    }
}
