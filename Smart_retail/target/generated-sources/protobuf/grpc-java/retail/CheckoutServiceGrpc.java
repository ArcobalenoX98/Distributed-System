package retail;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: retail.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CheckoutServiceGrpc {

  private CheckoutServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "retail.CheckoutService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<retail.Retail.CartItem,
      retail.Retail.CheckoutResponse> getCheckoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Checkout",
      requestType = retail.Retail.CartItem.class,
      responseType = retail.Retail.CheckoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<retail.Retail.CartItem,
      retail.Retail.CheckoutResponse> getCheckoutMethod() {
    io.grpc.MethodDescriptor<retail.Retail.CartItem, retail.Retail.CheckoutResponse> getCheckoutMethod;
    if ((getCheckoutMethod = CheckoutServiceGrpc.getCheckoutMethod) == null) {
      synchronized (CheckoutServiceGrpc.class) {
        if ((getCheckoutMethod = CheckoutServiceGrpc.getCheckoutMethod) == null) {
          CheckoutServiceGrpc.getCheckoutMethod = getCheckoutMethod =
              io.grpc.MethodDescriptor.<retail.Retail.CartItem, retail.Retail.CheckoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Checkout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  retail.Retail.CartItem.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  retail.Retail.CheckoutResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CheckoutServiceMethodDescriptorSupplier("Checkout"))
              .build();
        }
      }
    }
    return getCheckoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CheckoutServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceStub>() {
        @java.lang.Override
        public CheckoutServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckoutServiceStub(channel, callOptions);
        }
      };
    return CheckoutServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CheckoutServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceBlockingStub>() {
        @java.lang.Override
        public CheckoutServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckoutServiceBlockingStub(channel, callOptions);
        }
      };
    return CheckoutServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CheckoutServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceFutureStub>() {
        @java.lang.Override
        public CheckoutServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckoutServiceFutureStub(channel, callOptions);
        }
      };
    return CheckoutServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<retail.Retail.CartItem> checkout(
        io.grpc.stub.StreamObserver<retail.Retail.CheckoutResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCheckoutMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CheckoutService.
   */
  public static abstract class CheckoutServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CheckoutServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CheckoutService.
   */
  public static final class CheckoutServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CheckoutServiceStub> {
    private CheckoutServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<retail.Retail.CartItem> checkout(
        io.grpc.stub.StreamObserver<retail.Retail.CheckoutResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getCheckoutMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CheckoutService.
   */
  public static final class CheckoutServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CheckoutServiceBlockingStub> {
    private CheckoutServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CheckoutService.
   */
  public static final class CheckoutServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CheckoutServiceFutureStub> {
    private CheckoutServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CHECKOUT = 0;

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
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECKOUT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.checkout(
              (io.grpc.stub.StreamObserver<retail.Retail.CheckoutResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCheckoutMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              retail.Retail.CartItem,
              retail.Retail.CheckoutResponse>(
                service, METHODID_CHECKOUT)))
        .build();
  }

  private static abstract class CheckoutServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CheckoutServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return retail.Retail.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CheckoutService");
    }
  }

  private static final class CheckoutServiceFileDescriptorSupplier
      extends CheckoutServiceBaseDescriptorSupplier {
    CheckoutServiceFileDescriptorSupplier() {}
  }

  private static final class CheckoutServiceMethodDescriptorSupplier
      extends CheckoutServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CheckoutServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CheckoutServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CheckoutServiceFileDescriptorSupplier())
              .addMethod(getCheckoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
