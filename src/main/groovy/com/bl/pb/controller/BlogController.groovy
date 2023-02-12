package com.bl.pb.controller

import com.bl.pb.entity.Blog
import com.bl.pb.entity.Result
import com.bl.pb.service.BlogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RequestMapping("/api/blog")
@RestController
class BlogController {

    @Autowired
    private BlogService blogService;

//    @GetMapping("/list")
//    Result<Map<String, Object>> queryByPage(@RequestParam(defaultValue = "1") int page,
//                                            @RequestParam(defaultValue = "10") int pageSize) {
//        return blogService.queryBlogByPage(page, pageSize)
//    }

    @GetMapping("/list")
    Result<Map<String, Object>> queryByPage(@RequestParam(defaultValue = "1") int page,
                                            @RequestParam(defaultValue = "10") int pageSize,
                                            @RequestParam(defaultValue = "") String tittle,
                                            @RequestParam(defaultValue = "") String desc,
                                            @RequestParam(defaultValue = "") String author) {

        Blog param = new Blog();
        param.tittle = tittle
        param.desc = desc
        param.author = author
        return blogService.queryBlogByPage(page, pageSize, param)
    }

    @GetMapping("/query/{blogId}")
    Result<Map<String, Object>> queryDetail(@PathVariable Integer blogId){
        return blogService.queryById(blogId)
    }

    @PostMapping("/save")
    Result<Map<String, Object>> saveBlog(@RequestBody Blog blog) {
        return blogService.saveBlog(blog)
    }

    @PostMapping("/update")
    Result<Map<String, Object>> updateBlog(@RequestBody Blog blog) {
        return blogService.updateById(blog)
    }

    @PostMapping("/delete")
    Result<Map<String, Object>> deleteBlog(@RequestBody Blog blog) {
        return blogService.deleteById(blog)
    }
}
