package com.liaojiexin.springcloud.service.impl;

import com.liaojiexin.springcloud.dao.OrderMapper;
import com.liaojiexin.springcloud.entity.Account;
import com.liaojiexin.springcloud.entity.Order;
import com.liaojiexin.springcloud.entity.Storage;
import com.liaojiexin.springcloud.service.AccountService;
import com.liaojiexin.springcloud.service.OrderService;
import com.liaojiexin.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author liao
 * @Date 9:16 下午 2022/10/2
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    //下订单：下订单->减库存->扣余额-＞改（订单）状态
    @Override
    public Order create(Order order) {
        //1、下订单
        order.setCommodityCode("订单未完成");
        orderMapper.insertSelective(order);

        //2、减库存
        Storage storage=new Storage();
        storage.setId(1);
        storage.setCount(order.getCount());
        storageService.update(storage);

        //3、扣余额
        Account account=new Account();
        account.setId(1);
        account.setMoney(order.getMoney());
        account.setUserId("user1");
        accountService.update(account);

        //4、修改订单
        order.setCommodityCode("订单完成");
        orderMapper.updateByPrimaryKey(order);

        return order;
    }
}
