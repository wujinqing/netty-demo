package com.jin.netty.sixthexample;

import com.jin.protobuf.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import static com.jin.protobuf.MyDataInfo.MyMessage.DataType.CatType;
import static com.jin.protobuf.MyDataInfo.MyMessage.DataType.PersonType;

/**
 * Created by wujinqing on 17/6/12.
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        MyDataInfo.MyMessage.DataType dataType = msg.getDataType();

        if(PersonType == dataType)
        {
            MyDataInfo.Person person = msg.getPerson();

            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getAddress());

        } if(CatType == dataType)
        {
            MyDataInfo.Cat cat = msg.getCat();

            System.out.println(cat.getName());
            System.out.println(cat.getAge());

        }else
        {
            MyDataInfo.Dog dog = msg.getDog();

            System.out.println(dog.getName());
            System.out.println(dog.getCity());
        }
    }
}
