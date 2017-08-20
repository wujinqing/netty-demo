package com.jin.nio;

import java.nio.ByteBuffer;

/**
 * 只读Buffer, 和源buffer共享底层数组
 */
public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        for(int i = 0; i <byteBuffer.capacity(); i++)
        {
            byteBuffer.put((byte)i);
        }

        System.out.println(byteBuffer.getClass());

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();

        System.out.println(readOnlyBuffer.getClass());

        readOnlyBuffer.position(2);
        readOnlyBuffer.put((byte) 2);
    }
}
