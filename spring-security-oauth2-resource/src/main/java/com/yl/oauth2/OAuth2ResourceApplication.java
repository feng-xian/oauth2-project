package com.yl.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author : 凤仙
 * @Date : 2021/8/15 16:56
 * @Version : 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.yl.oauth2.resource.mapper")
public class OAuth2ResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ResourceApplication.class, args);
    }

}
