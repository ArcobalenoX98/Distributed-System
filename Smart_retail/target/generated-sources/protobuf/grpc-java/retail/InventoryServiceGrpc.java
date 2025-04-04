package retail;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: retail.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class InventoryServiceGrpc {

  private InventoryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "retail.InventoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<retail.Retail.StockRequest,
      retail.Retail.StockResponse> getGetStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStock",
      requestType = retail.Retail.StockRequest.class,
      responseType = retail.Retail.StockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<retail.Retail.StockRequest,
      retail.Retail.StockResponse> getGetStockMethod() {
    io.grpc.MethodDescriptor<retail.Retail.StockRequest, retail.Retail.StockResponse> getGetStockMethod;
    if ((getGetStockMethod = InventoryServiceGrpc.getGetStockMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getGetStockMethod = InventoryServiceGrpc.getGetStockMethod) == null) {
          InventoryServiceGrpc.getGetStockMethod = getGetStockMethod =
              io.grpc.MethodDescriptor.<retail.Retail.StockRequest, retail.Retail.StockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  retail.Retail.StockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  retail.Retail.StockResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("GetStock"))
              .build();
        }
      }
    }
    return getGetStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<retail.Retail.StockUpdate,
      retail.Retail.StockAlert> getMonitorStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorStock",
      requestType = retail.Retail.StockUpdate.class,
      responseType = retail.Retail.StockAlert.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<retail.Retail.StockUpdate,
      retail.Retail.StockAlert> getMonitorStockMethod() {
    io.grpc.MethodDescriptor<retail.Retail.StockUpdate, retail.Retail.StockAlert> getMonitorStockMethod;
    if ((getMonitorStockMethod = InventoryServiceGrpc.getMonitorStockMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getMonitorStockMethod = InventoryServiceGrpc.getMonitorStockMethod) == null) {
          InventoryServiceGrpc.getMonitorStockMethod = getMonitorStockMethod =
              io.grpc.MethodDescriptor.<retail.Retail.StockUpdate, retail.Retail.StockAlert>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  retail.Retail.StockUpdate.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  retail.Retail.StockAlert.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("MonitorStock"))
              .build();
        }
      }
    }
    return getMonitorStockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InventoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceStub>() {
        @java.lang.Override
        public InventoryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceStub(channel, callOptions);
        }
      };
    return InventoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InventoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingStub>() {
        @java.lang.Override
        public InventoryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceBlockingStub(channel, callOptions);
        }
      };
    return InventoryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InventoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceFutureStub>() {
        @java.lang.Override
        public InventoryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceFutureStub(channel, callOptions);
        }
      };
    return InventoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getStock(retail.Retail.StockRequest request,
        io.grpc.stub.StreamObserver<retail.Retail.StockResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStockMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<retail.Retail.StockUpdate> monitorStock(
        io.grpc.stub.StreamObserver<retail.Retail.StockAlert> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMonitorStockMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service InventoryService.
   */
  public static abstract class InventoryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return InventoryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service InventoryService.
   */
  public static final class InventoryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<InventoryServiceStub> {
    private InventoryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void getStock(retail.Retail.StockRequest request,
        io.grpc.stub.StreamObserver<retail.Retail.StockResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<retail.Retail.StockUpdate> monitorStock(
        io.grpc.stub.StreamObserver<retail.Retail.StockAlert> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMonitorStockMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service InventoryService.
   */
  public static final class InventoryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<InventoryServiceBlockingStub> {
    private InventoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public retail.Retail.StockResponse getStock(retail.Retail.StockRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStockMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service InventoryService.
   */
  public static final class InventoryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<InventoryServiceFutureStub> {
    private InventoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<retail.Retail.StockResponse> getStock(
        retail.Retail.StockRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STOCK = 0;
  private static final int METHODID_MONITOR_STOCK = 1;

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
        case METHODID_GET_STOCK:
          serviceImpl.getStock((retail.Retail.StockRequest) request,
              (io.grpc.stub.StreamObserver<retail.Retail.StockResponse>) responseObserver);
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
        case METHODID_MONITOR_STOCK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorStock(
              (io.grpc.stub.StreamObserver<retail.Retail.StockAlert>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetStockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              retail.Retail.StockRequest,
              retail.Retail.StockResponse>(
                service, METHODID_GET_STOCK)))
        .addMethod(
          getMonitorStockMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              retail.Retail.StockUpdate,
              retail.Retail.StockAlert>(
                service, METHODID_MONITOR_STOCK)))
        .build();
  }

  private static abstract class InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InventoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return retail.Retail.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InventoryService");
    }
  }

  private static final class InventoryServiceFileDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier {
    InventoryServiceFileDescriptorSupplier() {}
  }

  private static final class InventoryServiceMethodDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InventoryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (InventoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InventoryServiceFileDescriptorSupplier())
              .addMethod(getGetStockMethod())
              .addMethod(getMonitorStockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
