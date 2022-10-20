package com.tjnu.system.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.tjnu.frame.consts.SessionConst;
import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.frame.shiro.util.ShiroUtils;
import com.tjnu.system.entity.UserInfo;
import com.tjnu.system.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Controller
@RequestMapping("/system/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public ResponseResult doLogin(@RequestParam("username")String username,
                                  @RequestParam("password")String password){

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            UserInfo userInfo = userInfoService.getByUsername(username);
            System.out.println("我得到了userInfo：" + userInfo);

            if (userInfo.getStatus() == 3){
                return ResponseResult.error("对不起，您已被拉入黑名单，请及时联系客服");
            }

            ShiroUtils.setSessionAttribute(SessionConst.USER_INFO_SESSION,userInfo);
            UserInfo entity = (UserInfo) ShiroUtils.getSessionAttribute(SessionConst.USER_INFO_SESSION);
            System.out.println("嘿嘿，我这有："+entity);

            String loginSuccessUrl = "toIndex";
            if (ShiroUtils.getSessionAttribute(SessionConst.MOVIE_PAGE) != null){
                int movieId = (int) ShiroUtils.getSessionAttribute(SessionConst.MOVIE_PAGE);
                loginSuccessUrl = "toMovieDetail?id=" + movieId;

            }

            return ResponseResult.success("登录成功",loginSuccessUrl);
        }catch(UnknownAccountException e){
            return ResponseResult.error("用户不存在");
        }catch (IncorrectCredentialsException e){
            return ResponseResult.error("密码错误！");
        }
    }

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    @RequestMapping("/doRegister")
    @ResponseBody
    public ResponseResult doRegister(UserInfo userInfo){
        System.out.println("进入方法1" + userInfo);
        return userInfoService.saveEntity(userInfo);
    }

    //更新用户信息
    @RequestMapping("/UpdateEntity")
    @ResponseBody
    public ResponseResult UpdateEntity(UserInfo entity){
        return userInfoService.UpdateEntity(entity);
    }

    //更新密码
    @RequestMapping("/updatePwd")
    @ResponseBody
    public ResponseResult updatePwd(@RequestParam("id")int id,
                              @RequestParam("oldPassword")String oldPassword,
                              @RequestParam("newPassword1")String newPassword1,
                              @RequestParam("newPassword2")String newPassword2){
        if (StringUtils.isBlank(oldPassword)){
            return ResponseResult.error("旧密码不能为空");
        }else if (StringUtils.isBlank(newPassword1)){
            return ResponseResult.error("新密码不能为空");
        }else if(StringUtils.isBlank(newPassword2)){
            return ResponseResult.error("请再次输入密码");
        }
        if (!newPassword1.equals(newPassword2)){
            return ResponseResult.error("两次密码输入不一致");
        }
        return userInfoService.updatePwd(id,oldPassword,newPassword1);
    }

    /*
        用户列表接口
     */
    @RequestMapping("init")
    public String init(){
        return "system/back/users_list";
    }

    @RequestMapping("initBlack")
    public String initBlack(){
        return "system/back/users_black_list";
    }

    //用户展示
    @RequestMapping("listByTable")
    @ResponseBody
    public ResponseResult ListByTable(UserInfo userInfo){
        return userInfoService.listByTable(userInfo);
    }

    //黑名单展示
    @RequestMapping("listBlack")
    @ResponseBody
    public ResponseResult listBlack(UserInfo userInfo){
        return userInfoService.listBlack(userInfo);
    }

    //拉入黑名单
    @RequestMapping("JoinBlackById")
    @ResponseBody
    public ResponseResult JoinBlackById(@RequestParam("id") int id){
        return userInfoService.JoinBlackById(id);
    }

    //退出白名单
    @RequestMapping("QuitBlackById")
    @ResponseBody
    public ResponseResult QuitBlackById(@RequestParam("id") int id){
        return userInfoService.QuitBlackById(id);
    }
}
