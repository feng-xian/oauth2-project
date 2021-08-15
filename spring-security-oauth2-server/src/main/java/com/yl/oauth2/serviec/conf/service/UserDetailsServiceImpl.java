package com.yl.oauth2.serviec.conf.service;

import com.yl.oauth2.serviec.entity.TbPermission;
import com.yl.oauth2.serviec.entity.TbUser;
import com.yl.oauth2.serviec.service.TbPermissionService;
import com.yl.oauth2.serviec.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : 凤仙
 * @Date : 2021/8/15 13:56
 * @Version : 1.0
 */
@Service("userDetailsServiceBean")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource(name = "TbUserServiceImpl")
    private TbUserService tbUserService;

    @Resource(name = "tbPermissionService")
    private TbPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.getUserByUsername(username);
        if (null == tbUser){
            return null;
        }
        List<TbPermission> permissionList = permissionService.getPermissionByUserId(tbUser.getId());
        ArrayList<GrantedAuthority> list = Lists.newArrayList();
        permissionList.forEach(tbPermission -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
            list.add(grantedAuthority);
        });
        return new User(username, tbUser.getPassword(), list);
    }
}
