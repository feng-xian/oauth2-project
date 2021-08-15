package com.yl.oauth2.serviec.controller;

import com.yl.oauth2.serviec.dto.LoginParam;
import com.yl.oauth2.serviec.dto.ResponseResult;
import com.yl.oauth2.serviec.utils.MapperUtils;
import com.yl.oauth2.serviec.utils.OkHttpClientUtil;
import okhttp3.Response;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author : 凤仙
 * @Date : 2021/8/15 20:13
 * @Version : 1.0
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserLoginController {

    private static final String URL = "http://localhost:8080/oauth/token";

    @Value("${business.oauth2.access_client_grant_type}")
    private String grant_type;

    @Value("${business.oauth2.access_client_client_id}")
    private String client_id;

    @Value("${business.oauth2.access_client_client_secret}")
    private String client_secret;

    @Resource(name = "userDetailsServiceBean")
    private UserDetailsService userDetailsService;

    @Resource(name = "passwordEncoder")
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping(value = "/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam loginParam){
        Map<String, Object> map = new HashMap<String, Object>(2);
        System.out.println("password-------------->"+loginParam.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (null == userDetails
                || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())){
            return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.FAIL, "账号或密码错误", null);
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("username", loginParam.getUsername());
        hashMap.put("password", loginParam.getPassword());
        hashMap.put("grant_type", grant_type);
        hashMap.put("client_id", client_id);
        hashMap.put("client_secret", client_secret);
        Response response = OkHttpClientUtil.getInstance().postData(URL, hashMap);
        try {
            String resp = Objects.requireNonNull(response.body()).string();
            System.out.println(resp);
            Map<String, Object> json2map = MapperUtils.json2map(resp);
            String accessToke = String.valueOf(json2map.get("access_token"));
            System.out.println("access toke is ------>: " + accessToke);
            map.put("token", accessToke);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.OK, HttpStatus.OK.toString(), map);
    }

    /*
    Response{protocol=http/1.1, code=401, message=, url=http://localhost:8080/oauth/token}
     */
}
