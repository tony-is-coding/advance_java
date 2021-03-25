package com.std.tony.zore_copy;

import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/24 8:18 下午
 */
public class FileSend {

    public static void main(String[] args) throws IOException {
        File file = new File("1.txt");
        FileInputStream in = new FileInputStream(file);
        FileRegion fr = new DefaultFileRegion(in.getChannel(),0,file.length());
    }
}
