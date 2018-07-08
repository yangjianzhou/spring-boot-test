package com.iwill;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan({"com.iwill","org.unitils.boot.autoconfigure"})
@MapperScan(basePackages = "com.iwill.mapper")
//@EnableDubboConfiguration
public class CustomerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerTestApplication.class, args);
    }
}
