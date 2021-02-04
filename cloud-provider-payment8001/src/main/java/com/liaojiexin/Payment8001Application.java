package com.liaojiexin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: Payment8001Application
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/3 17:18
 */
@SpringBootApplication
@MapperScan(value = "com.liaojiexin.dao") //该标签可以让指定包下的文件为Mapper，这样就该包下文件可以省略@Mapper标签
public class Payment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Application.class, args);
    }
}
