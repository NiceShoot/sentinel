package com.dongao.sentinel.service;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author Eric Zhao
 */
public final class ExceptionUtil {

    public static void handleException(BlockException ex) {
        System.out.println("Oops: " + ex.getClass().getCanonicalName());
    }
}