package com.tjnu.system.controller;


import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.system.entity.AppointmentInfo;
import com.tjnu.system.entity.MovieInfo;
import com.tjnu.system.entity.UserInfo;
import com.tjnu.system.service.AppointmentInfoService;
import com.tjnu.system.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Controller
@RequestMapping("/system/movieInfo")
public class MovieInfoController {

    @Autowired
    MovieInfoService movieInfoService;

    //新增
    @Autowired
    AppointmentInfoService appointmentInfoService;

    @RequestMapping("init")
    public String initMovies(){
        return "system/back/movies_list";
    }

    //电影展示
    @RequestMapping("listByTable")
    @ResponseBody
    public ResponseResult ListByTable(MovieInfo movieInfo){
        return movieInfoService.listByTable(movieInfo);
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public ResponseResult deleteById(@RequestParam("id") int id){
        //新增代码
        List<AppointmentInfo> list = appointmentInfoService.list();
        for (AppointmentInfo appointmentInfo : list) {
            if (appointmentInfo.getMovieId() == id){
                return ResponseResult.error("此电影有预约在先，无法下架");
            }
        }

        //原代码
        boolean b = movieInfoService.removeById(id);
        if (!b){
            return ResponseResult.error("下架失败");
        }
        return ResponseResult.success("下架成功");
    }

    @RequestMapping("updateById")
    @ResponseBody
    public ResponseResult updateById(MovieInfo entity){
        boolean b = movieInfoService.updateById(entity);
        if (!b){
            return ResponseResult.error("更新失败");
        }
        return ResponseResult.success("更新成功");
    }

    @RequestMapping("save")
    @ResponseBody
    public ResponseResult save(MovieInfo entity){
        System.out.println("我要新增电影啦："+entity);
        boolean save = movieInfoService.save(entity);
        if (!save){
            return ResponseResult.error("上传失败");
        }
        return ResponseResult.success("上传成功");
    }

}
