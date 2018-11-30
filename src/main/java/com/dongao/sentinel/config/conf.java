package com.dongao.sentinel.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.config
 * @Description: ${todo}
 * @date 2018/11/30 11:39
 */
public class conf {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }
}