package com.tjnu.system.service.impl;

import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.system.entity.FeedbackInfo;
import com.tjnu.system.entity.MovieInfo;
import com.tjnu.system.mapper.FeedbackInfoMapper;
import com.tjnu.system.service.FeedbackInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Service
public class FeedbackInfoServiceImpl extends ServiceImpl<FeedbackInfoMapper, FeedbackInfo> implements FeedbackInfoService {

    @Override
    public ResponseResult listByTable(FeedbackInfo feedbackInfo) {
        return ResponseResult.table(baseMapper.countByTable(feedbackInfo),baseMapper.listByTable(feedbackInfo));
    }
}
