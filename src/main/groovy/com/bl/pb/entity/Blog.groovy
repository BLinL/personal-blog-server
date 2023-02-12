package com.bl.pb.entity

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat

import java.time.LocalDateTime

class Blog {
    Integer blogId
    String tittle
    String author
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime
    String content
    String desc
}
