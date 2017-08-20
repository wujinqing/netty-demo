package com.jin.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: Course.proto")
public final class CourseServiceGrpc {

  private CourseServiceGrpc() {}

  public static final String SERVICE_NAME = "com.jin.proto.CourseService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.jin.proto.CourseReq,
      com.jin.proto.CourseRes> METHOD_GET_COURSE_BY_ID =
      io.grpc.MethodDescriptor.<com.jin.proto.CourseReq, com.jin.proto.CourseRes>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.jin.proto.CourseService", "getCourseById"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.jin.proto.CourseReq.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.jin.proto.CourseRes.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CourseServiceStub newStub(io.grpc.Channel channel) {
    return new CourseServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CourseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CourseServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CourseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CourseServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CourseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCourseById(com.jin.proto.CourseReq request,
        io.grpc.stub.StreamObserver<com.jin.proto.CourseRes> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_COURSE_BY_ID, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_COURSE_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.jin.proto.CourseReq,
                com.jin.proto.CourseRes>(
                  this, METHODID_GET_COURSE_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class CourseServiceStub extends io.grpc.stub.AbstractStub<CourseServiceStub> {
    private CourseServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCourseById(com.jin.proto.CourseReq request,
        io.grpc.stub.StreamObserver<com.jin.proto.CourseRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_COURSE_BY_ID, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CourseServiceBlockingStub extends io.grpc.stub.AbstractStub<CourseServiceBlockingStub> {
    private CourseServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.jin.proto.CourseRes getCourseById(com.jin.proto.CourseReq request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_COURSE_BY_ID, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CourseServiceFutureStub extends io.grpc.stub.AbstractStub<CourseServiceFutureStub> {
    private CourseServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jin.proto.CourseRes> getCourseById(
        com.jin.proto.CourseReq request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_COURSE_BY_ID, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COURSE_BY_ID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CourseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CourseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COURSE_BY_ID:
          serviceImpl.getCourseById((com.jin.proto.CourseReq) request,
              (io.grpc.stub.StreamObserver<com.jin.proto.CourseRes>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class CourseServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.jin.proto.Course.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CourseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CourseServiceDescriptorSupplier())
              .addMethod(METHOD_GET_COURSE_BY_ID)
              .build();
        }
      }
    }
    return result;
  }
}
