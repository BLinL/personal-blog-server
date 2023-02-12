package com.bl.pb.dao

import com.bl.pb.entity.Blog
import org.apache.ibatis.annotations.Mapper

@Mapper
interface BlogDao {

    List<Blog> queryByParam(Blog blog)

    List<Blog> listAll()

    int save(Blog blog);

    int updateById(Blog blog);

    int deleteById(int blogId)
}
