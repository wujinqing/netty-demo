package com.jin.netty.practice.first;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author wu.jinqing
 * @date 2017年06月01日
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("channelRead0 invoked!");

        System.out.println(msg);
        ctx.writeAndFlush("hello world");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive invoked!");
        ctx.writeAndFlush("hello world2");
    }


    @Override
    public boolean acceptInboundMessage(Object msg) throws Exception {
        System.out.println("acceptInboundMessage invoked!");

        return super.acceptInboundMessage(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead invoked!");

        super.channelRead(ctx, msg);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered invoked!");

        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelUnregistered invoked!");

        super.channelUnregistered(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive invoked!");

        super.channelInactive(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelReadComplete invoked!");

        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("userEventTriggered invoked!");

        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelWritabilityChanged invoked!");

        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exceptionCaught invoked!");

        super.exceptionCaught(ctx, cause);
    }

    @Override
    protected void ensureNotSharable() {
        System.out.println("ensureNotSharable invoked!");

        super.ensureNotSharable();
    }

    @Override
    public boolean isSharable() {
        System.out.println("isSharable invoked!");

        return super.isSharable();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded invoked!");

        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved invoked!");

        super.handlerRemoved(ctx);
    }
}
