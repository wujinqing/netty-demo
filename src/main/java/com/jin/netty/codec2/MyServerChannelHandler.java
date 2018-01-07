package com.jin.netty.codec2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * Created by wujinqing on 17/5/20.
 */
public class MyServerChannelHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] buffer = new byte[msg.readableBytes()];

        msg.readBytes(buffer);
        System.out.println("服务器端接收到的消息：" + new String(buffer, "utf-8"));

        System.out.println("服务器端接收到的消息数量：" + (++ this.count));

        String res = UUID.randomUUID().toString();
        ByteBuf byteBuf = Unpooled.copiedBuffer(res.getBytes("utf-8"));
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }




}
