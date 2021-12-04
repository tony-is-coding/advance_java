package com.cnc.my.mybatis.mybaits_cache_theory.decorator;

import com.cnc.my.mybatis.mybaits_cache_theory.CacheDecorator;
import com.cnc.my.mybatis.mybaits_cache_theory.CacheImplementor;

public class LRUCache implements CacheDecorator {
    private final CacheImplementor delegate;

    public LRUCache(CacheImplementor delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object key, Object value) {

    }

    @Override
    public Object getObject(Object key) {
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }
}
