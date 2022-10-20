package com.tjnu.system.service.impl;

import com.tjnu.frame.consts.SessionConst;
import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.frame.shiro.util.ShiroUtils;
import com.tjnu.system.entity.AppointmentInfo;
import com.tjnu.system.mapper.AppointmentInfoMapper;
import com.tjnu.system.service.AppointmentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjnu.system.vo.AppointmentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class AppointmentInfoServiceImpl extends ServiceImpl<AppointmentInfoMapper, AppointmentInfo> implements AppointmentInfoService {

    @Autowired
    AppointmentInfoMapper appointmentInfoMapper;

    /**
     * 点击预约事件
     * @param entity
     * @param createTime
     * @return
     */
    @Override
    public ResponseResult saveAppointment(AppointmentInfo entity,int createTime) {
        if (entity.getUserId() == null){
            //保存电影详情页面
            ShiroUtils.setSessionAttribute(SessionConst.MOVIE_PAGE,entity.getMovieId());
            return ResponseResult.error("请先登录");
        }
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(d);

        //设置开始时间和结束时间的预约
        try {
            switch(createTime){
                case 1:entity.setStartTime(new Timestamp(df.parse(format).getTime()+3600000*8));entity.setEndTime(new Timestamp(df.parse(format).getTime()+3600000*10));break;
                case 2:entity.setStartTime(new Timestamp(df.parse(format).getTime()+3600000*10));entity.setEndTime(new Timestamp(df.parse(format).getTime()+3600000*12));break;
                case 3:entity.setStartTime(new Timestamp(df.parse(format).getTime()+3600000*12));entity.setEndTime(new Timestamp(df.parse(format).getTime()+3600000*14));break;
                case 4:entity.setStartTime(new Timestamp(df.parse(format).getTime()+3600000*14));entity.setEndTime(new Timestamp(df.parse(format).getTime()+3600000*16));break;
                case 5:entity.setStartTime(new Timestamp(df.parse(format).getTime()+3600000*16));entity.setEndTime(new Timestamp(df.parse(format).getTime()+3600000*18));break;
                case 6:entity.setStartTime(new Timestamp(df.parse(format).getTime()+3600000*18));entity.setEndTime(new Timestamp(df.parse(format).getTime()+3600000*20));break;
                case 7:entity.setStartTime(new Timestamp(df.parse(format).getTime()+3600000*20));entity.setEndTime(new Timestamp(df.parse(format).getTime()+3600000*22));break;
                case 8:entity.setStartTime(new Timestamp(df.parse(format).getTime()+3600000*22));entity.setEndTime(new Timestamp(df.parse(format).getTime()+3600000*24));break;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //设置进程为1(未开始)
        entity.setProcess(1);

        int re1 = baseMapper.countAppointmentRepeat(entity);
        int re2 = baseMapper.countRoomRepeat(entity);
        //判断是否重复预约
        if (re1 == 1){
            return ResponseResult.error("请勿重复预约");
        }
        //判断是否房间在该时间段被占用
        if (re2 == 1){
            return  ResponseResult.error("抱歉，该房间在此时间段已被预约");
        }

        int insert = baseMapper.insert(entity);
        if (insert <= 0){
            return ResponseResult.error("预约失败");
        }
        return ResponseResult.success("预约成功");
    }

    /**
     * 展示用户预约表
     * @param appointmentInfovo
     * @return
     */
    @Override
    public ResponseResult listByTable(AppointmentInfoVo appointmentInfovo) {
        return ResponseResult.table(appointmentInfoMapper.countById(appointmentInfovo),appointmentInfoMapper.listByTable(appointmentInfovo));
    }

    /**
     * 后台展示所有预约
     * @param entity
     * @return
     */
    @Override
    public ResponseResult listAll(AppointmentInfoVo entity) {
        return ResponseResult.table(baseMapper.countAll(entity),baseMapper.listAll(entity));
    }

    @Override
    public ResponseResult listAll2(AppointmentInfoVo entity) {
        return ResponseResult.table(baseMapper.countAll2(entity),baseMapper.listAll2(entity));
    }

    /**
     * 预约未完成-》正在进行中
     * @param id
     * @return
     */
    @Override
    public ResponseResult updateProcessTwo(int id) {
        int i = baseMapper.updateProcessTwo(id);
        if (i <= 0){
            ResponseResult.error("修改失败");
        }
        return ResponseResult.success("状态修改成功");
    }

    /**
     * 预约正在进行中-》已完成
     * @param id
     * @return
     */
    @Override
    public ResponseResult updateProcessThree(int id) {
        int i = baseMapper.updateProcessThree(id);
        if (i <= 0){
            ResponseResult.error("修改失败");
        }
        return ResponseResult.success("订单已完成");
    }

    /**
     * 总收入
     * @return
     */
    @Override
    public int TotalMoney() {
        return baseMapper.TotalMoney();
    }

    /**
     * 总成交订单数
     * @return
     */
    @Override
    public int TotalAppointment() {
        return baseMapper.TotalAppointment();
    }

    /**
     * 总正在进行订单数
     * @return
     */
    @Override
    public int TotalProcessingAppointment() {
        return baseMapper.TotalProcessingAppointment();
    }
}
