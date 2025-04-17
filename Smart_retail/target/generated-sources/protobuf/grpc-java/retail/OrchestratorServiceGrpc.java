package retail;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: orchestrator.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrchestratorServiceGrpc {

  private OrchestratorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "retail.OrchestratorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<retail.OrderRequest,
      retail.OrderResponse> getProcessOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessOrder",
      requestType = retail.OrderRequest.class,
      responseType = retail.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<retail.OrderRequest,
      retail.OrderResponse> getProcessOrderMethod() {
    io.grpc.MethodDescriptor<retail.OrderRequest, retail.OrderResponse> getProcessOrderMethod;
    if ((getProcessOrderMethod = OrchestratorServiceGrpc.getProcessOrderMethod) == null) {
      synchronized (OrchestratorServiceGrpc.class) {
        if ((getProcessOrderMethod = OrchestratorServiceGrpc.getProcessOrderMethod) == null) {
          OrchestratorServiceGrpc.getProcessOrderMethod = getProcessOrderMethod =
              io.grpc.MethodDescriptor.<retail.OrderRequest, retail.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  retail.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  retail.OrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrchestratorServiceMethodDescriptorSupplier("ProcessOrder"))
              .build();
        }
      }
    }
    return getProcessOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrchestratorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrchestratorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrchestratorServiceStub>() {
        @java.lang.Override
        public OrchestratorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrchestratorServiceStub(channel, callOptions);
        }
      };
    return OrchestratorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrchestratorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrchestratorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrchestratorServiceBlockingStub>() {
        @java.lang.Override
        public OrchestratorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrchestratorServiceBlockingStub(channel, callOptions);
        }
      };
    return OrchestratorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrchestratorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrchestratorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrchestratorServiceFutureStub>() {
        @java.lang.Override
        public OrchestratorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrchestratorServiceFutureStub(channel, callOptions);
        }
      };
    return OrchestratorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void processOrder(retail.OrderRequest request,
        io.grpc.stub.StreamObserver<retail.OrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessOrderMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OrchestratorService.
   */
  public static abstract class OrchestratorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OrchestratorServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OrchestratorService.
   */
  public static final class OrchestratorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OrchestratorServiceStub> {
    private OrchestratorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrchestratorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrchestratorServiceStub(channel, callOptions);
    }

    /**
     */
    public void processOrder(retail.OrderRequest request,
        io.grpc.stub.StreamObserver<retail.OrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OrchestratorService.
   */
  public static final class OrchestratorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrchestratorServiceBlockingStub> {
    private OrchestratorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrchestratorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrchestratorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public retail.OrderResponse processOrder(retail.OrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OrchestratorService.
   */
  public static final class OrchestratorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrchestratorServiceFutureStub> {
    private OrchestratorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrchestratorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrchestratorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<retail.OrderResponse> processOrder(
        retail.OrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_ORDER = 0;

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
        case METHODID_PROCESS_ORDER:
          serviceImpl.processOrder((retail.OrderRequest) request,
              (io.grpc.stub.StreamObserver<retail.OrderResponse>) responseObserver);
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
          getProcessOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              retail.OrderRequest,
              retail.OrderResponse>(
                service, METHODID_PROCESS_ORDER)))
        .build();
  }

  private static abstract class OrchestratorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrchestratorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return retail.OrchestratorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrchestratorService");
    }
  }

  private static final class OrchestratorServiceFileDescriptorSupplier
      extends OrchestratorServiceBaseDescriptorSupplier {
    OrchestratorServiceFileDescriptorSupplier() {}
  }

  private static final class OrchestratorServiceMethodDescriptorSupplier
      extends OrchestratorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OrchestratorServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OrchestratorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrchestratorServiceFileDescriptorSupplier())
              .addMethod(getProcessOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
