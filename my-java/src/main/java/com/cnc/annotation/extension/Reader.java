package com.cnc.annotation.extension;

/**
 * @author tony
 * @desc 拓展接口
 * @createDate 2021/3/18 3:42 下午
 */

@SPI
public interface Reader {
    int read(byte[] target);

    byte readByte();
}
