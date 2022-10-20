package com.tjnu.frame.dto;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * @author bobo
 * @date    2021/05/26
 */
public class BaseEntity {

    @TableField(exist = false)
    private int page;

    //显示数据的行数
    @TableField(exist = false)
    private int offset;

    //从第几条数据开始，不包括当前数据，比如limit=2，则从id=3开始
    @TableField(exist = false)
    private int limit;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getOffset() {
        return (page - 1) * limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
