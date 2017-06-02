package com.jin.netty.practice.bytebuf;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author wu.jinqing
 * @date 2017年06月01日
 */
public class ByteBufClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(new ByteBufClientHandler());
    }
}
