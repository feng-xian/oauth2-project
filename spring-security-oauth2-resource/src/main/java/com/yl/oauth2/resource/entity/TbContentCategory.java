package com.yl.oauth2.resource.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


import java.io.Serializable;

/**
 * 内容分类(TbContentCategory)表实体类
 *
 * @author makejava
 * @since 2021-08-15 17:02:43
 */
@Data
@Table(name = "tb_content_category")
public class TbContentCategory implements Serializable{

    private static final long serialVersionUID = -1861406870141994656L;

    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 分类名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 状态。可选值:1(正常),2(删除)
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 该类目是否为父类目，1为true，0为false
     */
    @Column(name = "is_parent")
    private Integer isParent;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;



}
