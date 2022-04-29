package com.cnc.my.spring.beans;

/**
 * com.cnc.my.spring.beans - WireComponentBean
 *
 * @author tony-is-coding
 * @date 2022/4/29 17:46
 */
public class WireComponentBean {

    private final ComponentBean componentBean;

    public WireComponentBean(ComponentBean componentBean) {
        this.componentBean = componentBean;
    }

}
