package com.jin.netty.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * Created by wujinqing on 17/5/20.
 */
public class MyServerChannelHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLenght();
        byte[] content = msg.getContent();

        System.out.println("接收到来自客户端的消息。");
        System.out.println("长度：" + length);
        System.out.println("内容：" + new String(content, "utf-8"));
        System.out.println("服务器端接收到的消息数量：" + (++this.count));

        String res = UUID.randomUUID().toString();

        byte[] resContent = res.getBytes("utf-8");
        int resLength = resContent.length;

        PersonProtocol p = new PersonProtocol();

        p.setLenght(resLength);
        p.setContent(resContent);

        ctx.writeAndFlush(p);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }




}
