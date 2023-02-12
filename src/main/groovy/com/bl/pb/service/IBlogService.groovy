package com.bl.pb.service

import com.bl.pb.entity.Blog
import com.bl.pb.entity.Result

interface IBlogService {
    Result saveBlog(Blog blog)

    Result updateById(Blog blog)

    Result deleteById(Blog blog)

    Result queryByParam(Blog blog)

    Result<Map<String, Object>> queryById(int blogId)
}