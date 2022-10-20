package com.tjnu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tjnu.frame.consts.SessionConst;
import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.frame.shiro.util.ShiroUtils;
import com.tjnu.system.entity.UserInfo;
import com.tjnu.system.mapper.UserInfoMapper;
import com.tjnu.system.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 根据唯一账号获取用户信息
     * @param username
     * @return
     */
    @Override
    public UserInfo getByUsername(String username) {
        UserInfo userInfoVo = new UserInfo();
        UserInfo userInfo = baseMapper.selectOne(
                new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUsername, username));
        BeanUtils.copyProperties(userInfo, userInfoVo);
        return userInfoVo;
    }

    /**
     * 注册用户
     * @param entity
     * @return
     */
    @Override
    public ResponseResult saveEntity(UserInfo entity) {
        //查询user_info表中的所有name 是否和 添加的entity的name 有相同的
        List<UserInfo> existList = baseMapper.selectList(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUsername,entity.getUsername()));
        if(!CollectionUtils.isEmpty(existList)){
            return ResponseResult.error("用户名已存在"+entity.getUsername());
        }
        UserInfo userInfo = baseMapper.selectOneByPhone(entity.getPhone());
        if(userInfo != null){
            return ResponseResult.error("手机号已存在");
        }
        entity.setNickname(entity.getUsername());
        //设置盐值
        entity.setSalt(ShiroUtils.getRandomSalt());
        //设置加密密码
        entity.setPassword(ShiroUtils.genPassword(entity.getPassword(),entity.getSalt()));
        //设置用户角色
        entity.setRole(1);
        entity.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        baseMapper.insert(entity);
        //保存用户信息
        ShiroUtils.setSessionAttribute(SessionConst.USER_INFO_SESSION,entity);
        return ResponseResult.success("注册成功");
    }

    /**
     * 更新用户信息
     * @param entity
     * @return
     */
    @Override
    public ResponseResult UpdateEntity(UserInfo entity) {
        System.out.println("entity === " + entity);
        int i = baseMapper.updateById(entity);
        if (i <= 0){
            return ResponseResult.error("保存失败");
        }
        ShiroUtils.setSessionAttribute(SessionConst.USER_INFO_SESSION,entity);
        return ResponseResult.success("保存成功");
    }

    /**
     * 更新密码
     * @param id
     * @param oldPassword
     * @param newPassword1
     * @return
     */
    @Override
    public ResponseResult updatePwd(int id, String oldPassword, String newPassword1) {
        UserInfo userInfo = baseMapper.selectById(id);
        if (userInfo == null){
            return ResponseResult.error("用户不存在");
        }

        if (!ShiroUtils.genPassword(oldPassword,userInfo.getSalt()).equals(userInfo.getPassword())){
            return ResponseResult.error("旧密码不正确");
        }

        userInfo.setPassword(ShiroUtils.genPassword(newPassword1,userInfo.getSalt()));
        int i = baseMapper.updateById(userInfo);
        if (i <= 0){
            return ResponseResult.error("修改失败");
        }
        ShiroUtils.removeSessionAttribute(SessionConst.USER_INFO_SESSION);
        return ResponseResult.success("修改成功");
    }

    /**
     * 展示用户列表
     * @param userInfo
     * @return
     */
    @Override
    public ResponseResult listByTable(UserInfo userInfo) {
        return ResponseResult.table(baseMapper.countByTable(userInfo),baseMapper.listByTable(userInfo));
    }

    /**
     * 黑名单列表
     * @param userInfo
     * @return
     */
    @Override
    public ResponseResult listBlack(UserInfo userInfo) {
        return ResponseResult.table(baseMapper.countBlack(userInfo),baseMapper.listBlack(userInfo));
    }

    /**
     * 加入黑名单
     * @param id
     * @return
     */
    @Override
    public ResponseResult JoinBlackById(int id) {
        int i = baseMapper.JoinBlackById(id);
        if (i <= 0){
            return ResponseResult.error("加入黑名单失败");
        }
        return ResponseResult.success("加入黑名单成功");
    }

    /**
     * 加入白名单
     * @param id
     * @return
     */
    @Override
    public ResponseResult QuitBlackById(int id) {
        int i = baseMapper.QuitBlackById(id);
        if (i <= 0){
            return ResponseResult.error("退出黑名单失败");
        }
        return ResponseResult.success("加入白名单成功");
    }


}
