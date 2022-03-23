package com.cnc.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class JDK8Lambda {

    public static void main(String[] args) {
        com.basic.BatchApplier<String> applier = new com.basic.BatchApplier<>();
        List<String> as = Arrays.asList("1111", "3333", "2222", "0000", "5555", "4444");
        com.basic.FunctionClass fc = new com.basic.FunctionClass();

        // 实现接口模式
        applier.batchApply(as, fc::outline);
//
//        // 转换模式
//        applier.batchApply(as, System.out::println);
//
//        // convert
//        applier.batchApply(as, x -> {
//        });
        as.sort(String::indexOf);
    }
}

class LambdaImpl<T, R> extends com.basic.LambdaHolder<T, R> implements com.basic.FunctionInterface<T> {

    public LambdaImpl(Function<? super T, R> function) {
        super(function);
    }

    @Override
    public void outline(T t) {
        delegate(t);
    }
}

abstract class LambdaHolder<T, R> {
    private Function<? super T, R> function;

    public LambdaHolder(Function<? super T, R> function) {
        this.function = function;
    }

    protected R delegate(T t) {
        return function.apply(t);
    }
}

class BatchApplier<T> {
    void batchApply(Collection<T> cs, com.basic.FunctionInterface<T> itf) {
        cs.forEach(itf::outline);
    }
}

@FunctionalInterface
interface FunctionInterface<T> {
    void outline(T t);
}

class FunctionClass {
    public String outline(String x) {
        System.out.println(x + "klasjlkdjalsd");
        return x + "sssssss";
    }
}
