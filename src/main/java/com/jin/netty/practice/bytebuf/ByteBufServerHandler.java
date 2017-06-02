package com.jin.netty.practice.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author wu.jinqing
 * @date 2017年06月01日
 */
public class ByteBufServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("来自客户端的消息：" + new String(msg.array(), "utf-8"));
    }
}
