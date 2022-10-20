package com.tjnu.system.controller;


import com.tjnu.frame.consts.SessionConst;
import com.tjnu.frame.shiro.util.ShiroUtils;
import com.tjnu.system.consts.AppointmentInfoConst;
import com.tjnu.system.consts.MovieInfoConst;
import com.tjnu.system.consts.RoomInfoConst;
import com.tjnu.system.consts.UserInfoConst;
import com.tjnu.system.entity.MovieInfo;
import com.tjnu.system.entity.RoomInfo;
import com.tjnu.system.entity.UserInfo;
import com.tjnu.system.service.AppointmentInfoService;
import com.tjnu.system.service.MovieInfoService;
import com.tjnu.system.service.RoomInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JumpController {

    @Autowired
    MovieInfoService movieInfoService;
    @Autowired
    RoomInfoService roomInfoService;
    @Autowired
    AppointmentInfoService appointmentInfoService;

    public void getSession(Model model){
        UserInfo userInfo = (UserInfo) ShiroUtils.getSessionAttribute(SessionConst.USER_INFO_SESSION);
        if(userInfo != null){
            model.addAttribute(UserInfoConst.NICK_NAME, userInfo.getNickname());
            model.addAttribute(UserInfoConst.USER_INFO,userInfo);
            model.addAttribute(UserInfoConst.ROLE_ADMIN,userInfo.getRole());
        }
    }

    /**
     * 跳转首页
     * @param model
     * @return
     */
    @RequestMapping({"/toIndex","/"})
    public String toIndex(Model model){
        getSession(model);
        List<MovieInfo> topMovies = movieInfoService.listByScore();
        //热门电影
        model.addAttribute(MovieInfoConst.TOP_MOVIES,topMovies);
        return "system/index";
    }

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "system/login";
    }

    /**
     * 跳转注册页面
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "system/register";
    }

    /**
     * 跳转电影列表页面
     * @return
     */
    @RequestMapping("/toMovieList")
    public String toMovieList(Model model){
        getSession(model);
        List<MovieInfo> list = movieInfoService.list();
        model.addAttribute(MovieInfoConst.MOVIES_LIST,list);
        return "system/movie-list";
    }

    /**
     * 跳转电影详情页面
     * @return
     */
    @RequestMapping("/toMovieDetail")
    public String toMovieDetail(@RequestParam("id")int id, Model model){
        getSession(model);
        MovieInfo movieInfo = movieInfoService.selectOneById(id);
        List<MovieInfo> similarMovies = movieInfoService.listFourByType(movieInfo.getMovieType(),movieInfo.getId());
        //类似电影
        model.addAttribute(MovieInfoConst.SIMILAR_TYPE_MOVIES,similarMovies);
        //电影详情
        model.addAttribute(MovieInfoConst.MOVIES_DETAIL,movieInfo);

        //房间详情
        List<RoomInfo> roomList = roomInfoService.list();
        model.addAttribute(RoomInfoConst.ROOM_LIST,roomList);

        return "system/movie-detail";
    }

    /**
     * 跳转反馈页面
     * @return
     */
    @RequestMapping("/toFeedback")
    public String toFeedback(Model model){
        getSession(model);
        return "system/feedback";
    }

    @RequestMapping("/toMyAccount")
    public String toMyAccount(Model model){
        getSession(model);
        return "system/my-account";
    }

    @RequestMapping("/LoginOut")
    public String LoginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "system/index";
    }

    @RequestMapping("/toBackIndex")
    public String home(Model model){
        getSession(model);
        return "system/back/index";
    }

    @RequestMapping("/toWelcome")
    public String toWelcome(Model model){
        getSession(model);
        int totalMovies = movieInfoService.TotalMovies();
        int totalAppointment = appointmentInfoService.TotalAppointment();
        int totalMoney = appointmentInfoService.TotalMoney();
        int totalProcessingAppointment = appointmentInfoService.TotalProcessingAppointment();

        model.addAttribute(AppointmentInfoConst.TOTAL_MOVIES,totalMovies);
        model.addAttribute(AppointmentInfoConst.TOTAL_PROCESSING_APPOINTMENT,totalProcessingAppointment);
        model.addAttribute(AppointmentInfoConst.TOTAL_APPOINTMENT,totalAppointment);
        model.addAttribute(AppointmentInfoConst.TOTAL_MONEY,totalMoney);
        return "system/back/welcome";
    }

}
