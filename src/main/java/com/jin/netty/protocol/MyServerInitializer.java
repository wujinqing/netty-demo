package com.jin.netty.protocol;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by wujinqing on 17/5/20.
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(new MyByteToPersonDecoder());
        channelPipeline.addLast(new MyPersonToByteEncoder());

        channelPipeline.addLast(new MyServerChannelHandler());
    }
}
