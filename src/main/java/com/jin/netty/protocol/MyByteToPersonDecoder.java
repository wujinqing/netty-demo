package com.jin.netty.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyByteToPersonDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToPersonDecoder decode invoked!");
        int length = in.readInt();
        byte[] content = new byte[length];

        in.readBytes(content);

        PersonProtocol p = new PersonProtocol();

        p.setLenght(length);
        p.setContent(content);

        out.add(p);
    }
}
