package com.tjnu.system.mapper;

import com.tjnu.system.entity.FeedbackInfo;
import com.tjnu.system.entity.RoomInfo;
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
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    int countByTable(@Param("entity") RoomInfo entity);

    List<RoomInfo> listByTable(@Param("entity") RoomInfo entity);

}
