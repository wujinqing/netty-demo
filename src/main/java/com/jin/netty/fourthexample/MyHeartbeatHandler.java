package com.jin.netty.fourthexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Created by wujinqing on 17/5/21.
 */
public class MyHeartbeatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        Channel channel = ctx.channel();

        if(evt instanceof IdleStateEvent)
        {
            IdleStateEvent event = (IdleStateEvent)evt;

            String eventType = "";

            switch (event.state())
            {
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲";
                    break;
            }

            System.out.println(channel.remoteAddress() + "触发事件: " + eventType);

            channel.close();
        }

    }
}
