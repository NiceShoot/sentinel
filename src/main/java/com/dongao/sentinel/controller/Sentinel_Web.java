package com.dongao.sentinel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.controller
 * @Description: ${todo}
 * @date 2018/11/30 14:29
 */
@Controller
public class Sentinel_Web {


    @RequestMapping(value = "/sentinelWeb")
    @ResponseBody
    public String sentinelWeb(){
        return "sentinelWeb";
    }

    @RequestMapping(value = "/sentinelWeb_block")
    public String sentinelWeb_block(){
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("","");
        return "error/error";
    }
}