package com.jin.netty.practice.protobuf;

import com.jin.protobuf.DataInfo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by wujinqing on 17/6/3.
 */
public class ProtoBufServerHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {
        System.out.println("来自客户端: " + msg.getName());

        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("李四").setAge(50).setAddress("上海虹桥").build();
//ctx.channel().writeAndFlush(msg);
        ctx.writeAndFlush(student);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();

        ctx.close();
    }
}
