package com.bl.pb.entity;

import com.github.pagehelper.PageInfo;

class PageVO {
    int pageSize;
    long total;

    static PageVO of(PageInfo<?> info) {
        PageVO pageVO = new PageVO();
        pageVO.pageSize = info.getPageSize();
        pageVO.total = info.getTotal();
        return pageVO;
    }
}
