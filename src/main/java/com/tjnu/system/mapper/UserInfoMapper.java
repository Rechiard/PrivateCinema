package com.tjnu.system.mapper;

import com.tjnu.system.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo selectOneByPhone(@Param("phone") String phone);

    int countByTable(@Param("entity") UserInfo entity);

    List<UserInfo> listByTable(@Param("entity") UserInfo entity);

    int countBlack(@Param("entity") UserInfo entity);

    List<UserInfo> listBlack(@Param("entity") UserInfo entity);

    int JoinBlackById(@Param("id") int id);

    int QuitBlackById(@Param("id") int id);

}
