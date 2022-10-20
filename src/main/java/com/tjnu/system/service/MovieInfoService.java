package com.tjnu.system.service;

import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.system.entity.MovieInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tjnu.system.entity.RoomInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Service
public interface MovieInfoService extends IService<MovieInfo> {

    ResponseResult listByTable(MovieInfo movieInfo);

    MovieInfo selectOneById(int id);

    List<MovieInfo> listFourByType(int movieType,int id);

    List<MovieInfo> listByScore();

    int TotalMovies();
}
