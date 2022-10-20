package com.tjnu.system.service;

import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.system.entity.RoomInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tjnu.system.entity.UserInfo;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Service
public interface RoomInfoService extends IService<RoomInfo> {

    ResponseResult listByTable(RoomInfo roomInfo);


}
