package retail;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: retail.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RecommendationServiceGrpc {

  private RecommendationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "retail.RecommendationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<retail.Retail.RecommendationRequest,
      retail.Retail.Product> getGetRecommendationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecommendations",
      requestType = retail.Retail.RecommendationRequest.class,
      responseType = retail.Retail.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<retail.Retail.RecommendationRequest,
      retail.Retail.Product> getGetRecommendationsMethod() {
    io.grpc.MethodDescriptor<retail.Retail.RecommendationRequest, retail.Retail.Product> getGetRecommendationsMethod;
    if ((getGetRecommendationsMethod = RecommendationServiceGrpc.getGetRecommendationsMethod) == null) {
      synchronized (RecommendationServiceGrpc.class) {
        if ((getGetRecommendationsMethod = RecommendationServiceGrpc.getGetRecommendationsMethod) == null) {
          RecommendationServiceGrpc.getGetRecommendationsMethod = getGetRecommendationsMethod =
              io.grpc.MethodDescriptor.<retail.Retail.RecommendationRequest, retail.Retail.Product>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecommendations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  retail.Retail.RecommendationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  retail.Retail.Product.getDefaultInstance()))
              .setSchemaDescriptor(new RecommendationServiceMethodDescriptorSupplier("GetRecommendations"))
              .build();
        }
      }
    }
    return getGetRecommendationsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecommendationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceStub>() {
        @java.lang.Override
        public RecommendationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommendationServiceStub(channel, callOptions);
        }
      };
    return RecommendationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecommendationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceBlockingStub>() {
        @java.lang.Override
        public RecommendationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommendationServiceBlockingStub(channel, callOptions);
        }
      };
    return RecommendationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecommendationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommendationServiceFutureStub>() {
        @java.lang.Override
        public RecommendationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommendationServiceFutureStub(channel, callOptions);
        }
      };
    return RecommendationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getRecommendations(retail.Retail.RecommendationRequest request,
        io.grpc.stub.StreamObserver<retail.Retail.Product> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRecommendationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RecommendationService.
   */
  public static abstract class RecommendationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RecommendationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RecommendationService.
   */
  public static final class RecommendationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RecommendationServiceStub> {
    private RecommendationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommendationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommendationServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRecommendations(retail.Retail.RecommendationRequest request,
        io.grpc.stub.StreamObserver<retail.Retail.Product> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetRecommendationsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RecommendationService.
   */
  public static final class RecommendationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RecommendationServiceBlockingStub> {
    private RecommendationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommendationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommendationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<retail.Retail.Product> getRecommendations(
        retail.Retail.RecommendationRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetRecommendationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RecommendationService.
   */
  public static final class RecommendationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RecommendationServiceFutureStub> {
    private RecommendationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommendationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommendationServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_RECOMMENDATIONS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RECOMMENDATIONS:
          serviceImpl.getRecommendations((retail.Retail.RecommendationRequest) request,
              (io.grpc.stub.StreamObserver<retail.Retail.Product>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetRecommendationsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              retail.Retail.RecommendationRequest,
              retail.Retail.Product>(
                service, METHODID_GET_RECOMMENDATIONS)))
        .build();
  }

  private static abstract class RecommendationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecommendationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return retail.Retail.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecommendationService");
    }
  }

  private static final class RecommendationServiceFileDescriptorSupplier
      extends RecommendationServiceBaseDescriptorSupplier {
    RecommendationServiceFileDescriptorSupplier() {}
  }

  private static final class RecommendationServiceMethodDescriptorSupplier
      extends RecommendationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RecommendationServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RecommendationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecommendationServiceFileDescriptorSupplier())
              .addMethod(getGetRecommendationsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
