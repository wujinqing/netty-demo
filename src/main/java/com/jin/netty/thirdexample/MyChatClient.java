package com.jin.netty.thirdexample;

import com.jin.netty.secondexample.MyClientInitializer;
import com.sun.tools.hat.internal.parser.ReadBuffer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.sun.jmx.remote.internal.IIOPHelper.connect;
import static javafx.scene.input.KeyCode.R;

/**
 * Created by wujinqing on 17/5/20.
 */
public class MyChatClient {
    public static void main(String[] args) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new MyChatClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

           for(;;)
           {
               channel.writeAndFlush(br.readLine() + "\r\n");
           }


        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
