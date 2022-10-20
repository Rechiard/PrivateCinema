package com.tjnu.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tjnu.frame.dto.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("appointment_info")
@ApiModel(value="AppointmentInfo对象", description="")
public class AppointmentInfo extends BaseEntity {


    @ApiModelProperty(value = "预定ID")
    @TableId("id")
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "电影ID")
    @TableField("movie_id")
    private Integer movieId;

    @ApiModelProperty(value = "房间ID")
    @TableField("room_id")
    private Integer roomId;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
    @TableField("start_time")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("end_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
    private Date endTime;

    @ApiModelProperty(value = "预约进程，1为未开始，2为正在进行，3为已完成，4位已过期")
    @TableField("process")
    private Integer process;

    @ApiModelProperty(value = "状态，1为正常，2为删除")
    @TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status;


}
