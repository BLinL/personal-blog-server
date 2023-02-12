package com.bl.pb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/hi")
@RestController
class HelloController {

    @GetMapping("/")
    def hi() {
        return "hi";
    }
}
