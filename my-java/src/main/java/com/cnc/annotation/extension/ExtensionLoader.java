package com.cnc.annotation.extension;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author tony
 * @desc 拓展接口实现加载处
 * @createDate 2021/3/18 3:45 下午
 */
public class ExtensionLoader {

    private static final String RESOURCE_BASE = "META-INF/extensions/";

    synchronized public static <E> E getClassLoader(Class<E> inter) {
        if (inter == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        if (!inter.isInterface()) {

        }
        return null;
    }


    public static void main(String[] args) throws IOException {
        ClassLoader loader = ExtensionLoader.class.getClassLoader();
        String fileName = "META-INF/extensions/1.txt";

        Enumeration<URL> urls = loader.getResources(fileName);
        while (urls.hasMoreElements()) {
            System.out.println("===========");
            URL url = urls.nextElement();
            System.out.println(url);
        }

    }
}
