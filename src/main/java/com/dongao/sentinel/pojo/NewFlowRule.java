package com.dongao.sentinel.pojo;

import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;

/**
 * @author jiabing
 * @Package com.dongao.sentinel.pojo
 * @Description: ${todo}
 * @date 2018/11/29 10:56
 */
public class NewFlowRule extends FlowRule {

    public NewFlowRule() {
        super();
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}