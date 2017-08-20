package com.jin.proto.test;

import com.jin.proto.CourseReq;
import com.jin.proto.CourseRes;
import com.jin.proto.CourseServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * Created by wujinqing on 17/7/20.
 */
public class CourseServiceImpl extends CourseServiceGrpc.CourseServiceImplBase {
    @Override
    public void getCourseById(CourseReq request, StreamObserver<CourseRes> responseObserver) {
        System.out.println("课程ID:" + request.getId());

        CourseRes res = CourseRes.newBuilder().setName("Java").build();

        responseObserver.onNext(res);
        responseObserver.onCompleted();

    }
}
