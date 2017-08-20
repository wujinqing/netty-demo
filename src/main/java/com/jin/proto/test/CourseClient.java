package com.jin.proto.test;

import com.jin.proto.CourseReq;
import com.jin.proto.CourseRes;
import com.jin.proto.CourseServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by wujinqing on 17/7/20.
 */
public class CourseClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext(true).build();

        CourseServiceGrpc.CourseServiceBlockingStub blockingStub = CourseServiceGrpc.newBlockingStub(channel);

        CourseReq req = CourseReq.newBuilder().setId(123).build();

        CourseRes res = blockingStub.getCourseById(req);

        System.out.println(res.getName());
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

}
