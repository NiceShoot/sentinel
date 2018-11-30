package com.dongao.sentinel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.controller
 * @Description: 使用zk中的规则
 * @date 2018/11/27 13:38
 */
@Controller
public class QPSControl_zk {

    /**
     * 测试
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "hello_zk")
    @ResponseBody
    public String hello(Model model) {
        return "hello_zk/hello_zk";

    }
}