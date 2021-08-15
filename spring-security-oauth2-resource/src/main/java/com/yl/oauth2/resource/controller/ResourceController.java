package com.yl.oauth2.resource.controller;

import com.yl.oauth2.resource.dto.ResponseResult;
import com.yl.oauth2.resource.entity.TbContent;
import com.yl.oauth2.resource.service.TbContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author : 凤仙
 * @Date : 2021/8/15 18:54
 * @Version : 1.0
 */
@RestController
public class ResourceController {

    @Resource(name = "tbContentService")
    private TbContentService contentService;

    /**
     * /resource/getAll
     * @return
     */
    @GetMapping("/getAll")
    public ResponseResult<List<TbContent>> getAll(){
        List<TbContent> contentList = contentService.getAllContent();
        return new ResponseResult<List<TbContent>>(ResponseResult.CodeStatus.OK, "success",contentList);
    }

}
