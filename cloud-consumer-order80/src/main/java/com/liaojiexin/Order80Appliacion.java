package com.liaojiexin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: OrderAppliacion
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 14:07
 */
@MapperScan(value = "com.liaojiexin.dao") //该标签可以让指定包下的文件为Mapper，这样就该包下文件可以省略@Mapper标签
@SpringBootApplication
public class Order80Appliacion {

    public static void main(String[] args) {
        SpringApplication.run(Order80Appliacion.class,args);
    }
}
