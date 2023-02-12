package com.bl.pb.entity

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonOutput


def r = new Result<>().ok("hha")

println r.msg
println r.code

r.addData("name", "张三")

println r.data['name']

map = [name: 'aaa']
println JsonOutput.toJson(map)
println new ObjectMapper().writeValueAsString(r)