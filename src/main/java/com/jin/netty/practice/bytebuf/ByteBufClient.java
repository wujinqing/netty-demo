package com.jin.netty.practice.bytebuf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author wu.jinqing
 * @date 2017年06月01日
 */
public class ByteBufClient {
    public static void main(String[] args) throws Exception{
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ByteBufClientChannelInitializer());

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();

            channelFuture.channel().closeFuture().sync();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
