package com.dongao.sentinel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.controller
 * @Description: 流量限制  QPS
 * @date 2018/11/27 13:38
 */
@Controller
public class QPSControl {

    /**
     * 测试
     * @param model
     * @return
     */
    @RequestMapping(value = "hello")
    public String hello(Model model){
        model.addAttribute("hello","hello");
        return "hello/hello";
    }
}