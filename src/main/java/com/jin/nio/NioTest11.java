package com.jin.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class NioTest11 {
    public static void main(String[] args) throws Exception{
        System.out.println("开始");
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8899);
        serverSocketChannel.socket().bind(inetSocketAddress);



        int messageLength = 2 + 3 + 4;

        ByteBuffer[] buffers = new ByteBuffer[3];

        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);
        System.out.println("等待连接建立");
        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("连接建立");

        while (true)
        {
            int readLength = 0;

            while (readLength < messageLength)
            {
                long r = socketChannel.read(buffers);

                readLength += r;

                System.out.println("readLength: " + r);

                Arrays.asList(buffers).stream().map(b -> "position: " + b.position() + ", limit: " + b.limit()).forEach(System.out::println);
            }

            int writeLength = 0;

            Arrays.asList(buffers).stream().forEach(b -> b.flip());

            while (writeLength < messageLength)
            {
                long w = socketChannel.write(buffers);

                writeLength += w;

            }

            Arrays.asList(buffers).forEach(b -> b.clear());

            System.out.println("readLength: " + readLength + ", writeLength: " + writeLength);
        }
    }
}
