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
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if(msg instanceof HttpRequest)
        {
            HttpRequest httpRequest = (HttpRequest)msg;

            System.out.println("method:" + httpRequest.method() + ", uri:" + httpRequest.uri());
        }

        if(msg instanceof HttpContent)
        {
            System.out.println("content");
            HttpContent httpContent = (HttpContent)msg;

            System.out.println(httpContent.content().toString(CharsetUtil.UTF_8));
        }

        if(msg instanceof LastHttpContent)
        {
            LastHttpContent lastHttpContent = (LastHttpContent)msg;

            System.out.println(lastHttpContent.content().toString(CharsetUtil.UTF_8));
        }

        DefaultHttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_0, HttpResponseStatus.OK);


        HttpContent httpContent = new DefaultHttpContent(Unpooled.copiedBuffer("来自服务器的响应!".getBytes(CharsetUtil.UTF_8)));

        ctx.writeAndFlush(httpContent);

        LastHttpContent lastHttpContent = new DefaultLastHttpContent(Unpooled.copiedBuffer("结束!".getBytes(CharsetUtil.UTF_8)));

        ctx.writeAndFlush(lastHttpContent);

        ctx.writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
