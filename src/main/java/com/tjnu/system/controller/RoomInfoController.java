package com.tjnu.system.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.system.entity.MovieInfo;
import com.tjnu.system.entity.RoomInfo;
import com.tjnu.system.service.RoomInfoService;
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
@RequestMapping("/system/roomInfo")
public class RoomInfoController {

    @Autowired
    RoomInfoService roomInfoService;

    @RequestMapping("init")
    public String initRooms(){
        return "system/back/rooms_list";
    }

    //房间展示
    @RequestMapping("listByTable")
    @ResponseBody
    public ResponseResult ListByTable(RoomInfo roomInfo){
        return roomInfoService.listByTable(roomInfo);
    }

    @RequestMapping("updateById")
    @ResponseBody
    public ResponseResult updateById(RoomInfo entity){
        boolean b = roomInfoService.updateById(entity);
        if (!b){
            return ResponseResult.error("更新相关资料失败");
        }
        return ResponseResult.success("更新相关资料成功");
    }

    @RequestMapping("save")
    @ResponseBody
    public ResponseResult save(RoomInfo entity){
        boolean save = roomInfoService.save(entity);
        if (!save){
            return ResponseResult.error("新增房间失败");
        }
        return ResponseResult.success("新增房间成功");
    }

}
