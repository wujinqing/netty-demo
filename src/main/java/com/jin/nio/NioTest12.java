package com.jin.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioTest12 {
    public static void main(String[] args) throws IOException {
        int[] ports = new int[5];

        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;

        Selector selector = Selector.open();

        for(int i = 0; i < ports.length; i++)
        {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);

            ServerSocket serverSocket = serverSocketChannel.socket();

            InetSocketAddress address = new InetSocketAddress("localhost", ports[i]);
            serverSocket.bind(address);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("监听端口号：" + ports[i]);
        }

        while (true)
        {
            int numbers = selector.select();

            System.out.println("Numbers: " + numbers);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectionKeys.iterator();

            while (iter.hasNext())
            {
                SelectionKey selectionKey = iter.next();

                if(selectionKey.isAcceptable())
                {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();

                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    iter.remove();
                    System.out.println("获得客户端连接：" + socketChannel);
                }else  if(selectionKey.isReadable())
                {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    int byteReads = 0;

                    while (true)
                    {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

                        byteBuffer.clear();

                        int read = socketChannel.read(byteBuffer);

                        if(read <= 0)
                        {
                            break;
                        }

                        byteBuffer.flip();

                        socketChannel.write(byteBuffer);

                        byteReads += read;
                    }

                    System.out.println("读取：" + byteReads + "来自于：" + socketChannel);

                    iter.remove();
                }
            }






























        }


    }
}
