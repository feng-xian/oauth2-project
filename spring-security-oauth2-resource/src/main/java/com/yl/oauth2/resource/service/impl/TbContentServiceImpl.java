package com.yl.oauth2.resource.service.impl;

import com.yl.oauth2.resource.entity.TbContent;
import com.yl.oauth2.resource.mapper.TbContentMapper;
import com.yl.oauth2.resource.service.TbContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbContent)表服务实现类
 *
 * @author makejava
 * @since 2021-08-15 17:02:42
 */
@Service("tbContentService")
public class TbContentServiceImpl implements TbContentService {

    @Resource
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> getAllContent() {
        return tbContentMapper.selectAll();
    }
}
