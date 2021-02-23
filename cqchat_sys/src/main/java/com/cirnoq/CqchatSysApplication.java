package com.cirnoq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = "com.cirnoq.mapper")
@ComponentScan(basePackages = {"com.cirnoq","org.n3r.idworker"})
public class CqchatSysApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return  builder.sources(CqchatSysApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(CqchatSysApplication.class, args);
    }

}
