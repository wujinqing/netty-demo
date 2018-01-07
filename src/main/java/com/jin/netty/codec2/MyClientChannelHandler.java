package com.jin.netty.codec2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by wujinqing on 17/5/20.
 */
public class MyClientChannelHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] buffer = new byte[msg.readableBytes()];

        msg.readBytes(buffer);

        System.out.println("接收到来自服务器端的消息：" + new String(buffer, "utf-8"));
        System.out.println("客户端收到的消息数量：" + (++this.count));


    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientChannelHandler channelActive invoked!");
        for(int i = 0; i < 10; i++)
        {
            String message = "send from client i:" + i;
            ByteBuf byteBuf = Unpooled.copiedBuffer(message.getBytes("utf-8"));
            ctx.writeAndFlush(byteBuf);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
