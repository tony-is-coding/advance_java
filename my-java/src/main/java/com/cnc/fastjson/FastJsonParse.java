package com.cnc.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * <p>
 * #TODO: desc
 * </p>
 *
 * @author zhiyong.tan
 * @since 2022-08-09
 */
public class FastJsonParse {
    public static void main(String[] args) {
        JSONArray objects = JSON.parseArray("[1,2,3,4]");

        List<Integer> integers = objects.toJavaList(Integer.class);

        integers.forEach(System.out::println);
    }
}
