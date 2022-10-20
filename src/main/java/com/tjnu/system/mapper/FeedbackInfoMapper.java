package com.tjnu.system.mapper;

import com.tjnu.system.entity.FeedbackInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjnu.system.entity.UserInfo;
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
public interface FeedbackInfoMapper extends BaseMapper<FeedbackInfo> {

    int countByTable(@Param("entity") FeedbackInfo entity);

    List<FeedbackInfo> listByTable(@Param("entity") FeedbackInfo entity);

}
