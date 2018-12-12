package com.dongao.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.controller
 * @Description: 热点参数控制
 * @date 2018/11/30 14:29
 */
@Controller
public class Sentinel_Param {


    @RequestMapping(value = "/sentinelParam/{id}")
    @ResponseBody
    public String sentinelWeb(@PathVariable("id") int id){
        Entry entry = null;
        try {
            entry = SphU.entry("hello_param", EntryType.IN, 1, id);
            return "sentinelParam";
        }catch (BlockException e){
            e.printStackTrace();
            return "error";
        }finally {
            if (entry!=null)
                entry.exit();
        }

    }


}