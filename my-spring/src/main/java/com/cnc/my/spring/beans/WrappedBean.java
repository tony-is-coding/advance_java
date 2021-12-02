package com.cnc.my.spring.beans;


/**
 * java bean 规范之一就是拥有无参数的构造方法; 但是部分场景下需要逆规范设计来达到对象的安全性目的
 */
public class WrappedBean {

    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
