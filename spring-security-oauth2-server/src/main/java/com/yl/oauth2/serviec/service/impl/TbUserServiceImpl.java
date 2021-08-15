package com.yl.oauth2.serviec.service.impl;

import com.yl.oauth2.serviec.entity.TbUser;
import com.yl.oauth2.serviec.mapper.TbUserMapper;
import com.yl.oauth2.serviec.service.TbUserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @Author : 凤仙
 * @Date : 2021/8/14 19:38
 * @Version : 1.0
 */
@Service("TbUserServiceImpl")
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getUserByUsername(String username) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username", username);
        return tbUserMapper.selectOneByExample(example);
    }

}
