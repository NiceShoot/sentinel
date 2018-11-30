package com.dongao.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dongao.sentinel.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.controller
 * @Description: 注解支持
 * @date 2018/11/27 13:38
 */
@Controller
public class QPSControl_an {

    @Autowired
    private TestService testService;

    private final Integer MAX_COUNT = 2;

    /**
     * 测试注解支持
     * @param model
     * @return
     */
    @RequestMapping(value = "hello_ann")
    @ResponseBody
    public String hello(Model model){
        testService.test();
        return testService.hello(System.currentTimeMillis());
    }

}