package com.jin.netty.practice.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author wu.jinqing
 * @date 2017年06月01日
 */
public class HttpClientHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        if(msg instanceof HttpResponse)
        {
            HttpResponse httpResponse = (HttpResponse)msg;


            System.out.println("status:" + httpResponse.status());
        }

        if(msg instanceof HttpContent)
        {
            HttpContent httpContent = (HttpContent)msg;

            System.out.println(httpContent.content().toString(CharsetUtil.UTF_8));
        }

        if(msg instanceof LastHttpContent)
        {
            LastHttpContent lastHttpContent = (LastHttpContent)msg;

            System.out.println(lastHttpContent.content().toString(CharsetUtil.UTF_8));
        }


    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DefaultHttpRequest request = new DefaultHttpRequest(HttpVersion.HTTP_1_0, HttpMethod.POST, "/test");



        HttpContent httpContent = new DefaultHttpContent(Unpooled.copiedBuffer("来自客户端的问候!".getBytes(CharsetUtil.UTF_8)));

        ctx.writeAndFlush(httpContent);

        LastHttpContent lastHttpContent = new DefaultLastHttpContent(Unpooled.copiedBuffer("结束!".getBytes(CharsetUtil.UTF_8)));

        ctx.writeAndFlush(lastHttpContent);

        ctx.writeAndFlush(request);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
