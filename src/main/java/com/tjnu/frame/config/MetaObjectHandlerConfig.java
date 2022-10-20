package com.tjnu.frame.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author bobo
 * @date 2021/04/11
 */
@Slf4j
@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("status", 1, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
