package com.tjnu.system.service;

import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.system.entity.AppointmentInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tjnu.system.entity.UserInfo;
import com.tjnu.system.vo.AppointmentInfoVo;
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
public interface AppointmentInfoService extends IService<AppointmentInfo> {

    ResponseResult saveAppointment(AppointmentInfo entity,int createTime);

    ResponseResult listByTable(AppointmentInfoVo appointmentInfoVo);

    ResponseResult listAll(AppointmentInfoVo entity);

    ResponseResult listAll2(AppointmentInfoVo entity);

    int TotalMoney();

    ResponseResult updateProcessTwo(int id);

    ResponseResult updateProcessThree(int id);

    int TotalAppointment();

    int TotalProcessingAppointment();

}
