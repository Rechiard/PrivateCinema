package com.tjnu.system.service.impl;

import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.system.entity.RoomInfo;
import com.tjnu.system.mapper.RoomInfoMapper;
import com.tjnu.system.service.RoomInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Service
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo> implements RoomInfoService {

    @Override
    public ResponseResult listByTable(RoomInfo roomInfo) {
        return ResponseResult.table(baseMapper.countByTable(roomInfo),baseMapper.listByTable(roomInfo));
    }
}
