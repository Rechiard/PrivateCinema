package com.tjnu.system.controller;


import com.tjnu.frame.consts.SessionConst;
import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.frame.shiro.util.ShiroUtils;
import com.tjnu.system.entity.AppointmentInfo;
import com.tjnu.system.service.AppointmentInfoService;
import com.tjnu.system.vo.AppointmentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
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
@RequestMapping("/system/appointmentInfo")
public class AppointmentInfoController {

    @Autowired
    AppointmentInfoService appointmentInfoService;

    @RequestMapping("init")
    public String initAppointment(){
        return "system/back/appointments_list";
    }

    @RequestMapping("initHistory")
    public String initHistory(){
        return "system/back/history_list";
    }

    /**
     * 预约表
     * @param entity
     * @return
     */
    @RequestMapping("listAll")
    @ResponseBody
    public ResponseResult listAll(AppointmentInfoVo entity){
        return appointmentInfoService.listAll(entity);
    }

    /**
     * 成交表
     * @param entity
     * @return
     */
    @RequestMapping("listAll2")
    @ResponseBody
    public ResponseResult listAll2(AppointmentInfoVo entity){
        return appointmentInfoService.listAll2(entity);
    }



    /**
     * 预约未完成-》正在进行中
     * @param id
     * @return
     */
    @RequestMapping("updateProcessTwo")
    @ResponseBody
    public ResponseResult updateProcessTwo(int id){
       return appointmentInfoService.updateProcessTwo(id);
    }

    /**
     * 预约正在进行中-》已完成
     * @param id
     * @return
     */
    @RequestMapping("updateProcessThree")
    @ResponseBody
    public ResponseResult updateProcessThree(int id){
        return appointmentInfoService.updateProcessThree(id);
    }

    /**
     * 预约接口
     * @param entity
     * @param createTime
     * @return
     */
    @RequestMapping("saveAppointment")
    @ResponseBody
    public ResponseResult saveAppointment(AppointmentInfo entity,int createTime){
        System.out.println("createTime:" + createTime);
        System.out.println("roomId:" + entity.getRoomId());
        System.out.println("userId:" + entity.getUserId());
        return appointmentInfoService.saveAppointment(entity,createTime);
    }

    /**
     *
     * @param appointmentInfoVo
     * @return
     */
    @RequestMapping("listByTable")
    @ResponseBody
    public ResponseResult listByTable(AppointmentInfoVo appointmentInfoVo){
        return appointmentInfoService.listByTable(appointmentInfoVo);
    }

    /**
     * 根据id删除订单
     * @param id
     * @return
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public ResponseResult deleteById(int id){
        boolean b = appointmentInfoService.removeById(id);
        if (!b){
            return ResponseResult.error("删除失败");
        }
        return ResponseResult.success("删除成功");
    }



}
