package com.tjnu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.system.entity.MovieInfo;
import com.tjnu.system.mapper.MovieInfoMapper;
import com.tjnu.system.service.MovieInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Service
public class MovieInfoServiceImpl extends ServiceImpl<MovieInfoMapper, MovieInfo> implements MovieInfoService {

    @Override
    public ResponseResult listByTable(MovieInfo movieInfo) {
        return ResponseResult.table(baseMapper.countByTable(movieInfo),baseMapper.listByTable(movieInfo));
    }

    @Override
    public MovieInfo selectOneById(int id) {
        return baseMapper.selectOne(new LambdaQueryWrapper<MovieInfo>().eq(MovieInfo::getId,id));
    }

    //类似电影
    @Override
    public List<MovieInfo> listFourByType(int movieType,int id) {
        return baseMapper.listFourByType(movieType,id);
    }

    //热门电影
    @Override
    public List<MovieInfo> listByScore() {
        return baseMapper.listByScore();
    }

    @Override
    public int TotalMovies() {
        return baseMapper.TotalMovies();
    }


}
