package com.jin.nio;

import java.nio.ByteBuffer;

public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(10);
        buffer.putChar('我');
        buffer.putLong(14324L);

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getLong());
    }
}
