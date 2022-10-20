package com.tjnu.system.service;

import com.tjnu.frame.dto.ResponseResult;
import com.tjnu.system.entity.FeedbackInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tjnu.system.entity.MovieInfo;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 闫静文
 * @since 2022-02-10
 */
@Service
public interface FeedbackInfoService extends IService<FeedbackInfo> {

    ResponseResult listByTable(FeedbackInfo feedbackInfo);

}
