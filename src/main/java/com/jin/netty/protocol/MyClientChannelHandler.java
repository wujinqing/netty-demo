package com.jin.netty.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by wujinqing on 17/5/20.
 */
public class MyClientChannelHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLenght();
        byte[] content = msg.getContent();

        System.out.println("接收到来自服务器端的消息。");
        System.out.println("长度：" + length);
        System.out.println("内容：" + new String(content, "utf-8"));
        System.out.println("客户端收到的消息数量：" + (++ this.count));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i = 0; i < 10; i++)
        {
            String msg = "send form client i: " + i;

            PersonProtocol p = new PersonProtocol();

            byte[] content = msg.getBytes("utf-8");
            int length = content.length;

            p.setLenght(length);
            p.setContent(content);

            ctx.writeAndFlush(p);
        }


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
