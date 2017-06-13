package com.jin.netty.practice.protobuf;

import com.jin.protobuf.DataInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * Created by wujinqing on 17/6/3.
 */
public class ProtoBufServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // Decoders
        pipeline.addLast("frameDecoder",
                new LengthFieldBasedFrameDecoder(1048576, 0, 4, 0, 4));
        pipeline.addLast("protobufDecoder",
                new ProtobufDecoder(DataInfo.Student.getDefaultInstance()));

        // Encoder
        pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
        pipeline.addLast("protobufEncoder", new ProtobufEncoder());
        pipeline.addLast(new ProtoBufServerHandler());
    }
}
