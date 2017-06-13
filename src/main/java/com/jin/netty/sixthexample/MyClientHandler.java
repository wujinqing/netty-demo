package com.jin.netty.sixthexample;

import com.jin.protobuf.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

import static javafx.scene.input.KeyCode.M;

/**
 * Created by wujinqing on 17/6/12.
 */
public class MyClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int i= new Random().nextInt(3);

        MyDataInfo.MyMessage myMessage = null;

        if (0 == i)
        {
            MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
                    .setName("我是一个人").setAge(20).setAddress("上海")
                    .build();

            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType).setPerson(person).build();



        }else if(1 == i)
        {

            MyDataInfo.Cat cat = MyDataInfo.Cat.newBuilder().setName("我是一只猫").setAge(10).build();

            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType).setCat(cat).build();
        }else {
            MyDataInfo.Dog dog = MyDataInfo.Dog.newBuilder().setName("我是一只狗").setCity("上海").build();

            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType).setDog(dog).build();
        }

        ctx.writeAndFlush(myMessage);
    }
}
