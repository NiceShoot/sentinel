package com.dongao.sentinel.common;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.adapter.servlet.config.WebServletConfig;
import com.alibaba.csp.sentinel.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.common
 * @Description: block 异常处理
 * @date 2018/11/30 15:51
 */
public class UrlBlockHandlerImpl implements UrlBlockHandler {

    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer url = request.getRequestURL();

        if ("GET".equals(request.getMethod()) && StringUtil.isNotBlank(request.getQueryString())) {
            url.append("?").append(request.getQueryString());
        }
        //设置一个错误页面
        WebServletConfig.setBlockPage("/sentinelWeb_block");
        if (StringUtil.isEmpty(WebServletConfig.getBlockPage())) {
            writeDefaultBlockedPage(response);
        } else {
            String redirectUrl = WebServletConfig.getBlockPage() + "?http_referer=" + url.toString();
            // Redirect to the customized block page.
            response.sendRedirect(redirectUrl);
        }
    }

    private static void writeDefaultBlockedPage(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("Blocked by Sentinel (flow limiting)");
        out.flush();
        out.close();
    }
}