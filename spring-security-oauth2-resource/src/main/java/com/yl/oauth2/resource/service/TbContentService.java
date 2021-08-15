package com.yl.oauth2.resource.service;


import com.yl.oauth2.resource.entity.TbContent;

import java.util.List;

/**
 * (TbContent)表服务接口
 *
 * @author makejava
 * @since 2021-08-15 17:02:41
 */
public interface TbContentService {

    /**
     * 获取所有内容
     * @return
     */
    List<TbContent> getAllContent();

}
