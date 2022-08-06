package com.cnc.myboot.properties;

//@ConfigurationProperties(prefix = "calc.thread-pool")
//@Component
public class ThreadPoolProperties {
    PoolConfig defaults;
    PoolConfig select;
    PoolConfig store;

    public PoolConfig getDefaults() {
        return defaults;
    }

    public void setDefaults(PoolConfig defaults) {
        this.defaults = defaults;
    }

    public PoolConfig getSelect() {
        return select;
    }

    public void setSelect(PoolConfig select) {
        this.select = select;
    }

    public PoolConfig getStore() {
        return store;
    }

    public void setStore(PoolConfig store) {
        this.store = store;
    }

    public static class PoolConfig {
        Integer core;
        Integer max;
        Integer capacity;


        public Integer getCore() {
            return core;
        }

        public void setCore(Integer core) {
            this.core = core;
        }

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }
    }


    @Override
    public String toString() {
        return "ThreadPoolProperties{" +
                "defaults=" + defaults +
                ", select=" + select +
                ", store=" + store +
                '}';
    }
}
