package com.tjnu.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("room_info")
@ApiModel(value="RoomInfo对象", description="")
public class RoomInfo extends BaseEntity {


    @ApiModelProperty(value = "房间ID")
    @TableId("id")
    private Integer id;

    @ApiModelProperty(value = "房间名称")
    @TableField("room_name")
    private String roomName;

    @ApiModelProperty(value = "房间类型")
    @TableField("room_type")
    private String roomType;

    @ApiModelProperty(value = "房间号")
    @TableField("room_number")
    private Integer roomNumber;

    @ApiModelProperty(value = "房间价格")
    @TableField("room_price")
    private Integer roomPrice;

    @ApiModelProperty(value = "状态，1为正常，2为删除")
    @TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status;


}
