package com.jin.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++)
        {
            int randNumber = new SecureRandom().nextInt(20);
            buffer.put(randNumber);
        }

        buffer.flip();

        while (buffer.hasRemaining())
        {
            System.out.println(buffer.get());
        }
    }
}
