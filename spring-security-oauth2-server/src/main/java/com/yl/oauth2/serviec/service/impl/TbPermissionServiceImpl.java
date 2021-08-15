package com.yl.oauth2.serviec.service.impl;

import com.yl.oauth2.serviec.entity.TbPermission;
import com.yl.oauth2.serviec.mapper.TbPermissionDao;
import com.yl.oauth2.serviec.service.TbPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限表(TbPermission)表服务实现类
 *
 * @author 凤仙
 * @since 2021-05-26 21:59:18
 */
@Service("tbPermissionService")
public class TbPermissionServiceImpl<TbPermission> implements TbPermissionService {

    @Resource
    private TbPermissionDao tbPermissionDao;

    @Override
    public List<com.yl.oauth2.serviec.entity.TbPermission> getPermissionByUserId(Long userId) {
        return tbPermissionDao.getPermissionByUserId(userId);
    }
}
