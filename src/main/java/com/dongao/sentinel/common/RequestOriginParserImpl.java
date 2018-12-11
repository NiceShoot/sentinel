package com.dongao.sentinel.common;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.common
 * @Description: 从 HTTP 请求中解析 origin
 * @date 2018/11/30 15:42
 */
public class RequestOriginParserImpl implements RequestOriginParser{
    @Override
    public String parseOrigin(HttpServletRequest request) {

        String origin = request.getHeader("Origin");

        return "http://127.0.0.1/hello";
    }
}