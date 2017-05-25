package com.jin.netty.secondexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * Created by wujinqing on 17/5/20.
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast("lengthFieldBasedFrameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
        channelPipeline.addLast("lengthFieldPrepender", new LengthFieldPrepender(4));
        channelPipeline.addLast("stringDecoder", new StringDecoder(CharsetUtil.UTF_8));
        channelPipeline.addLast("stringEncoder", new StringEncoder(CharsetUtil.UTF_8));
        channelPipeline.addLast(new MyClientChannelHandler());
    }
}
