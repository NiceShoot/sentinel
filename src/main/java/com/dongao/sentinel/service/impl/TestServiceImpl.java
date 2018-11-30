package com.dongao.sentinel.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dongao.sentinel.service.ExceptionUtil;
import com.dongao.sentinel.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.service.impl
 * @Description: ${todo}
 * @date 2018/11/27 18:26
 */
@Service
public class TestServiceImpl implements TestService {


    @SentinelResource(value = "hello", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public void test() {
        System.out.println("Test");
    }

    @SentinelResource(value = "hello_an", blockHandler = "exceptionHandler")
    public String hello(long s) {
        return String.format("hello_an at %d", s);
    }

    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }

}