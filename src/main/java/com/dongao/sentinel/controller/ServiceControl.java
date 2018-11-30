package com.dongao.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.controller
 * @Description: 服务熔断降级
 * @date 2018/11/27 13:38
 */
@Controller
public class ServiceControl {

    /**
     * 测试
     * @param model
     * @return
     */
    @RequestMapping(value = "hello_2")
    @ResponseBody
    public String hello(Model model){
        Entry entry = null;
        ContextUtil.enter("Node_1","hello_2");
        try {
            // 资源名可使用任意有业务语义的字符串
            entry = SphU.entry("hello_2");
            Thread.sleep(10l);
            model.addAttribute("hello_2","hello_2");
            return "hello_2/hello_2";
        }catch (BlockException e){
            return "error/error";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "error/error";
        } finally {
            if (entry!=null)
                entry.exit();
            ContextUtil.exit();
        }
    }
}