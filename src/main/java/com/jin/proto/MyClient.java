package com.jin.proto;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by wujinqing on 17/6/24.
 */
public class MyClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext(true).build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(channel);
        MyRequest request = MyRequest.newBuilder().setUsername("haha").build();

        MyResponse response = blockingStub.getRealnameByUsername(request);

        System.out.println("realname:" + response.getRealname());

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
