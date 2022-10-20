package com.tjnu.privatecinema;

import com.tjnu.system.mapper.AppointmentInfoMapper;
import com.tjnu.system.service.MovieInfoService;
import com.tjnu.system.service.UserInfoService;
import com.tjnu.system.vo.AppointmentInfoVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PrivatecinemaApplicationTests {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    MovieInfoService movieInfoService;
    @Autowired
    AppointmentInfoMapper appointmentInfoMapper;

    @Test
    void contextLoads() throws ParseException {

        AppointmentInfoVo appointmentInfovo = new AppointmentInfoVo();
        appointmentInfovo.setUserId(1);
        appointmentInfovo.setLimit(20);
        appointmentInfovo.setPage(1);
        List<AppointmentInfoVo> appointmentInfoVos = appointmentInfoMapper.listByTable(appointmentInfovo);
        for (AppointmentInfoVo appointmentInfoVo : appointmentInfoVos) {
            System.out.println(appointmentInfoVo);
            System.out.println(appointmentInfoVo.getStartTime());
            System.out.println(appointmentInfoVo.getEndTime());
        }
    }

}
