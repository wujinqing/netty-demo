package com.jin.netty.practice.protobuf;

import com.jin.protobuf.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by wujinqing on 17/6/3.
 */
public class ProtoBufClientHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {
        System.out.println("来自服务器端:" + msg.getName());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("张三").setAge(20).setAddress("上海").build();

        byte[] student2ByteArray = student.toByteArray();

        ctx.writeAndFlush(student);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();

        ctx.close();
    }
}
