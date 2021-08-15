package com.yl.oauth2.serviec.mapper;

import com.yl.oauth2.serviec.entity.TbPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.BaseMapper;

import java.util.List;

/**
 * 权限表(TbPermission)表数据库访问层
 *
 * @author 凤仙
 * @since 2021-05-26 21:59:17
 */
public interface TbPermissionDao extends BaseMapper<TbPermission> {

    @Select("SELECT\n" +
            "\tp.id,\n" +
            "\tp.parent_id,\n" +
            "\tp.NAME,\n" +
            "\tp.enname \n" +
            "FROM\n" +
            "\ttb_user u\n" +
            "\tLEFT JOIN tb_user_role ur ON ur.user_id = u.id\n" +
            "\tLEFT JOIN tb_role_permission rp ON ur.role_id = rp.role_id\n" +
            "\tLEFT JOIN tb_permission p ON p.id = rp.permission_id \n" +
            "WHERE\n" +
            "\tu.id = #{userId}")
    List<TbPermission> getPermissionByUserId(@Param("userId") Long userId);

}

