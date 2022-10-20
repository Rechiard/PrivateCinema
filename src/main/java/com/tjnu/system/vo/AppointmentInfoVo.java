package com.tjnu.system.vo;

import com.tjnu.system.entity.AppointmentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class AppointmentInfoVo extends AppointmentInfo {

    private String roomName;

    private String movieName;

    private Integer roomNumber;

    private Integer roomPrice;

    private String roomType;

    private String nickname;

}
