package com.cnc.myspringboot.meta_annotations;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope(value = "prototype")
public @interface ProtoTypeScope {
}
