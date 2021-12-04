package com.cnc.my.mybatis.mybaits_cache_theory;

public interface Cache {
    String getId();

    void putObject(Object key, Object value);

    Object getObject(Object key);

    Object removeObject(Object key);

    void clear();
}
