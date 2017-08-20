package com.jin.proto.test;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Created by wujinqing on 17/7/20.
 */
public class CourseServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8899).addService(new CourseServiceImpl()).build().start();

        server.awaitTermination();
    }
}
