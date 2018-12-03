package com.dongao.sentinel.common;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import com.alibaba.csp.sentinel.util.StringUtil;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.common
 * @Description: 清洗一下资源   (比如将满足 /foo/:id 的 URL 都归到 /foo/* 资源下)
 *
 * @date 2018/11/30 14:41
 */
public class UrlCleanerImpl implements UrlCleaner {

    @Override
    public String clean(String originUrl) {
        if (StringUtil.isBlank(originUrl))
            return null;
        else
            return "hello";
    }
}