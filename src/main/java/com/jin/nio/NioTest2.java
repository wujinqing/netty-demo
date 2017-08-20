package com.jin.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("NioTest2.txt");

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        channel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.remaining() > 0)
        {
            System.out.println("Character: " + (char) byteBuffer.get());
        }

        fileInputStream.close();
    }
}
