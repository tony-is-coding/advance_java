package com.cnc.my.spring.spring.core;

import com.cnc.my.spring.beans.WrappedBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class SpringBeanWrapperTest {

    @Test
    public void testBeansWrapper() {

        BeanWrapper wrappedBean = new BeanWrapperImpl(new WrappedBean());
        wrappedBean.getPropertyDescriptors();
    }

}
