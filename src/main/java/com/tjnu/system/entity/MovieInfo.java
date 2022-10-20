package com.tjnu.system.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("movie_info")
@ApiModel(value="MovieInfo对象", description="")
public class MovieInfo extends BaseEntity {


    @ApiModelProperty(value = "电影ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "电影名称")
    @TableField("movie_name")
    private String movieName;

    @ApiModelProperty(value = "电影简介")
    @TableField("movie_description")
    private String movieDescription;

    @ApiModelProperty(value = "电影地区")
    @TableField("movie_region")
    private String movieRegion;

    //1.爱情 2.战争 3.喜剧 4.科幻 5.恐怖 6.动作 7.动画 8.惊悚 9.魔幻 10.青春 11.犯罪
    @ApiModelProperty(value = "电影类型")
    @TableField("movie_type")
    private Integer movieType;

    @ApiModelProperty(value = "电影评分")
    @TableField("movie_score")
    private BigDecimal movieScore;

    @ApiModelProperty(value = "电影主演")
    @TableField("movie_author")
    private String movieAuthor;

    @ApiModelProperty(value = "总时长")
    @TableField("movie_time")
    private Integer movieTime;

    @ApiModelProperty(value = "年份")
    @TableField("movie_year")
    private Integer movieYear;

    @ApiModelProperty(value = "宣传海报")
    @TableField("movie_img")
    private String movieImg;

    @ApiModelProperty(value = "状态，1位正常，2为删除")
    @TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status;


}
