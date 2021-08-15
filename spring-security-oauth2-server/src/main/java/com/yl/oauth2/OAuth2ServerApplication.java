package com.yl.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author : 凤仙
 * @Date : 2021/8/14 12:09
 * @Version : 1.0
 */

@SpringBootApplication
@MapperScan("com.yl.oauth2.serviec.mapper")
public class OAuth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class, args);
    }

}
