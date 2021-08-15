package com.yl.oauth2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author : 凤仙
 * @Date : 2021/8/14 12:10
 * @Version : 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Oauth2Test {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void startTest(){
        System.out.println("---------------------");
    }

    @Test
    public void passwordEncoder(){
        System.out.println(passwordEncoder.encode("secret"));
    }
}
