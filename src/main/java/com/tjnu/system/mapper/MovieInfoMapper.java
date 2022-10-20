package com.tjnu.system.mapper;

import com.tjnu.system.entity.MovieInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjnu.system.entity.UserInfo;
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
public interface MovieInfoMapper extends BaseMapper<MovieInfo> {

    int countByTable(@Param("entity") MovieInfo entity);

    List<MovieInfo> listByTable(@Param("entity") MovieInfo entity);

    List<MovieInfo> listFourByType(@Param("movieType")int movieType,@Param("id")int id);

    List<MovieInfo> listByScore();

    int TotalMovies();

}
