package com.jin.proto;

import io.grpc.stub.StreamObserver;

/**
 * Created by wujinqing on 17/6/24.
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealnameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("username: " + request.getUsername());

        MyResponse response = MyResponse.newBuilder().setRealname("zhan san").build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
