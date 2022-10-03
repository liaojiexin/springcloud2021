package com.liaojiexin.springcloud.service;

import com.liaojiexin.springcloud.entity.Order;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author liao
 * @Date 9:15 下午 2022/10/2
 **/
@Service
public interface OrderService {

    Order create(Order order);
}
