package com.yl.oauth2.serviec.service;

import com.yl.oauth2.serviec.entity.TbUser;

import java.util.List;

/**
 * 用户表(TbUser)表服务接口
 *
 * @author makejava
 * @since 2021-08-14 19:36:17
 */
public interface TbUserService {

    /**
     * 通过用户名获取用户信息
     * @param username 用户名 {@code String}
     * @return 用户信息 {@link TbUser}
     */
    TbUser getUserByUsername(String username);

}
