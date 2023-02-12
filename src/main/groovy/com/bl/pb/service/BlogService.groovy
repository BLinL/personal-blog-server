package com.bl.pb.service

import com.bl.pb.dao.BlogDao
import com.bl.pb.entity.Blog
import com.bl.pb.entity.Result
import com.bl.pb.entity.PageVO
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils

@Service
class BlogService implements IBlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    Result<Map<String, Object>> queryById(int blogId) {
        def param = new Blog();
        param.setBlogId(blogId)
        def blogList = blogDao.queryByParam(param)
        if (blogList != null)
            return Result.ok("查询成功").addData("blogInfo", blogList.get(0))
        else
            return Result.fail("找不到此文章")
    }

    Result<Map<String, Object>> queryBlogByPage(int page, int pageSize, Blog param) {
        PageHelper.startPage(page, pageSize)
        def blogList = blogDao.queryByParam(param)
        def pageInfo = new PageInfo<>(blogList)
        def result = new Result().ok()
        result.addData("page", PageVO.of(pageInfo))
                .addData("blogList", pageInfo.getList())
        return result
    }

    @Override
    Result saveBlog(Blog blog) {
        println blog.getCreateTime()
        int rows = blogDao.save(blog)
        if (rows != 1) {
            return Result.fail("保存失败")
        }
        return Result.ok("保存成功")
    }

    @Override
    Result updateById(Blog blog) {
        if (blog.blogId == null) {
            return Result.fail("文章不存在")
        }
        int rows = blogDao.updateById(blog)
        if (rows != 1) {
            return Result.fail("更新失败")
        }
        return Result.ok("更新成功")
    }

    @Override
    Result deleteById(Blog blog) {
        if (blog.blogId == null) {
            return Result.fail("文章不存在")
        }
        int rows = blogDao.deleteById(blog)
        if (rows != 1) {
            return Result.fail("删除失败")
        }
        return Result.ok("删除成功")
    }

    @Override
    Result queryByParam(Blog blog) {
        def blogList = blogDao.queryByParam(blog)
        return Result<?>.ok("查询成功").addData("blogList", blogList)
    }
}
