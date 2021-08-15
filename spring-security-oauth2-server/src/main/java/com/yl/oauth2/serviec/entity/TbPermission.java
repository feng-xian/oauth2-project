package com.yl.oauth2.serviec.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 权限表(TbPermission)实体类
 *
 * @author makejava
 * @since 2021-05-26 21:59:17
 */
@Data
@Accessors(chain = true)
@Table(name = "tb_permission")
public class TbPermission implements Serializable {
    private static final long serialVersionUID = -45608474875742696L;

    @Id
    @Column(name = "id")
    private Long id;
    /**
     * 父权限
     */
    @Column(name = "parent_id")
    private Long parentId;
    /**
     * 权限名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 权限英文名称
     */
    @Column(name = "enname")
    private String enname;
    /**
     * 授权路径
     */
    @Column(name = "url")
    private String url;
    /**
     * 备注
     */
    @Column(name = "description")
    private String description;

}
