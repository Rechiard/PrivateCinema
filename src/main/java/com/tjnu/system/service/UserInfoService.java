package com.tjnu.system.service;

import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.system.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Service
public interface UserInfoService extends IService<UserInfo> {

    UserInfo getByUsername(String username);

    ResponseResult saveEntity(UserInfo entity);

    ResponseResult UpdateEntity(UserInfo entity);

    ResponseResult updatePwd(int id, String oldPassword, String newPassword1);

    ResponseResult listByTable(UserInfo userInfo);

    ResponseResult listBlack(UserInfo userInfo);

    ResponseResult JoinBlackById(int id);

    ResponseResult QuitBlackById(int id);
}
