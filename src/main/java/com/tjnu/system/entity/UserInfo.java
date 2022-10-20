package com.tjnu.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tjnu.frame.dto.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

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
@TableName("user_info")
@ApiModel(value="UserInfo对象", description="")
public class UserInfo extends BaseEntity {


    @ApiModelProperty(value = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账号")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "盐值")
    @TableField("salt")
    private String salt;

    @ApiModelProperty(value = "用户名")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "注册时间")
    @TableField("register_date")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
    private Timestamp registerDate;

    @ApiModelProperty(value = "角色，1为用户，2为管理员")
    @TableField("role")
    private Integer role;

    @ApiModelProperty(value = "状态，1位正常，2位删除,3为拉入黑名单")
    @TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status;


}
