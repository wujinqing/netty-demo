package com.jin.netty.codec2;

import com.jin.netty.codec.MyByteToLongDecoder2;
import com.jin.netty.codec.MyLongToByteEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by wujinqing on 17/5/20.
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        System.out.println("MyServerInitializer invoked!");

        ChannelPipeline channelPipeline = ch.pipeline();


        channelPipeline.addLast(new MyServerChannelHandler());
    }
}
