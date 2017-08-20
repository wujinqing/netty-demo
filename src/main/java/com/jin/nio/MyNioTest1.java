package com.jin.nio;

import java.nio.IntBuffer;

public class MyNioTest1 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        intBuffer.put(1);
        intBuffer.put(2);
        intBuffer.put(3);

        System.out.println("C: " + intBuffer.capacity());
        System.out.println("L: " + intBuffer.limit());
        System.out.println("P: " + intBuffer.position());
        intBuffer.flip();

        System.out.println("C: " + intBuffer.capacity());
        System.out.println("L: " + intBuffer.limit());
        System.out.println("P: " + intBuffer.position());

        intBuffer.flip();
        intBuffer.clear();
        intBuffer.put(1);
        intBuffer.put(2);
        intBuffer.put(3);
        intBuffer.put(4);
        intBuffer.flip();
        System.out.println("C: " + intBuffer.capacity());
        System.out.println("L: " + intBuffer.limit());
        System.out.println("P: " + intBuffer.position());
    }
}
