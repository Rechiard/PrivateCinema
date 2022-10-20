package com.tjnu.system.mapper;

import com.tjnu.system.entity.AppointmentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjnu.system.vo.AppointmentInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */

@Mapper
public interface AppointmentInfoMapper extends BaseMapper<AppointmentInfo> {

    int countAppointmentRepeat(@Param("entity")AppointmentInfo entity);

    int countRoomRepeat(@Param("entity")AppointmentInfo entity);

    int countById(@Param("entity") AppointmentInfoVo entity);

    List<AppointmentInfoVo> listByTable(@Param("entity")AppointmentInfoVo entity);

    int updateProcessTwo(@Param("id")int id);

    int updateProcessThree(@Param("id")int id);

    int countAll(@Param("entity")AppointmentInfoVo entity);

    List<AppointmentInfoVo> listAll(@Param("entity")AppointmentInfoVo entity);

    int countAll2(@Param("entity")AppointmentInfoVo entity);

    List<AppointmentInfoVo> listAll2(@Param("entity")AppointmentInfoVo entity);

    int TotalMoney();

    int TotalAppointment();

    int TotalProcessingAppointment();
}
