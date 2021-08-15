package com.yl.oauth2.serviec.service;


import com.yl.oauth2.serviec.entity.TbPermission;

import java.util.List;

/**
 * 权限表(TbPermission)表服务接口
 *
 * @author 凤仙
 * @since 2021-05-26 21:59:18
 */
public interface TbPermissionService {

    /**
     * 通过用户id获取权限
     * @param userId 用户ID
     * @return 权限集合
     */
    List<TbPermission> getPermissionByUserId(Long userId);

}
