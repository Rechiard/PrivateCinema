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
@TableName("feedback_info")
@ApiModel(value="FeedbackInfo对象", description="")
public class FeedbackInfo extends BaseEntity {


    @ApiModelProperty(value = "反馈ID")
    @TableId("id")
    private Integer id;

    @ApiModelProperty(value = "问题类型")
    @TableField("feedback_type")
    private String feedbackType;

    @ApiModelProperty(value = "反馈描述")
    @TableField("feedback_description")
    private String feedbackDescription;

    @ApiModelProperty(value = "反馈时间")
    @TableField("feedback_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
    private Date feedbackTime;

    @ApiModelProperty(value = "状态，1为正常，2为删除")
    @TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status;


}
