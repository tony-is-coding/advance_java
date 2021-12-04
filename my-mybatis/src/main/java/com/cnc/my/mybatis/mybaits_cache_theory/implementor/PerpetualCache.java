package com.cnc.my.mybatis.mybaits_cache_theory.implementor;

import com.cnc.my.mybatis.mybaits_cache_theory.CacheImplementor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PerpetualCache implements CacheImplementor {
    private final Map<Object, Object> cache = new ConcurrentHashMap<>();

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
