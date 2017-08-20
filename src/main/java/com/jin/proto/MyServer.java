package com.jin.proto;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Created by wujinqing on 17/6/24.
 */
public class MyServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8899)
                .addService(new StudentServiceImpl())
                .build()
                .start();

        server.awaitTermination();
    }
}
