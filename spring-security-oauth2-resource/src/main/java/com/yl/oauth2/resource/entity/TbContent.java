package com.yl.oauth2.resource.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


import java.io.Serializable;

/**
 * (TbContent)表实体类
 *
 * @author makejava
 * @since 2021-08-15 17:02:39
 */
@Data
@Table(name = "tb_content")
public class TbContent implements Serializable{

    private static final long serialVersionUID = -8102762851057377092L;

    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 内容类目ID
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 内容标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 子标题
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * 标题描述
     */
    @Column(name = "title_desc")
    private String titleDesc;

    /**
     * 链接
     */
    @Column(name = "url")
    private String url;

    /**
     * 图片绝对路径
     */
    @Column(name = "pic")
    private String pic;

    /**
     * 图片2
     */
    @Column(name = "pic2")
    private String pic2;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

}
