package com.tjnu.system.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.system.entity.FeedbackInfo;
import com.tjnu.system.entity.RoomInfo;
import com.tjnu.system.service.FeedbackInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Controller
@RequestMapping("/system/feedbackInfo")
public class FeedbackInfoController {

    @Autowired
    FeedbackInfoService feedbackInfoService;

    @RequestMapping("init")
    public String initFeedback(){
        return "system/back/feedback_list";
    }

    //反馈展示
    @RequestMapping("listByTable")
    @ResponseBody
    public ResponseResult ListByTable(FeedbackInfo feedbackInfo){
        return feedbackInfoService.listByTable(feedbackInfo);
    }

    @RequestMapping("RemoveById")
    @ResponseBody
    public ResponseResult RemoveById(@RequestParam("id") int id){
        boolean b = feedbackInfoService.removeById(id);
        if (!b){
            return ResponseResult.error("因特殊原因，无法处理此问题");
        }
        return ResponseResult.success("已传达相关部门，加急处理中");
    }

    @RequestMapping("save")
    @ResponseBody
    public ResponseResult save(FeedbackInfo entity){


        System.out.println("收到投递信：" + entity);
        entity.setFeedbackTime(new Timestamp(System.currentTimeMillis()));
        boolean save = feedbackInfoService.save(entity);
        if (!save){
            return ResponseResult.error("投递反馈信失败");
        }
        return ResponseResult.success("投递成功，我们将及时处理！");
    }

}
