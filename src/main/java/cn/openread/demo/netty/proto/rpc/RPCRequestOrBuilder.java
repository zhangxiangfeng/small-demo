// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.openread.demo.netty.proto.rpc;

public interface RPCRequestOrBuilder extends
        // @@protoc_insertion_point(interface_extends:cn.openread.demo.netty.proto.rpc.RPCRequest)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int64 id = 1;</code>
     */
    long getId();

    /**
     * <code>optional string serviceName = 2;</code>
     */
    java.lang.String getServiceName();

    /**
     * <code>optional string serviceName = 2;</code>
     */
    com.google.protobuf.ByteString
    getServiceNameBytes();

    /**
     * <code>optional string methodName = 3;</code>
     */
    java.lang.String getMethodName();

    /**
     * <code>optional string methodName = 3;</code>
     */
    com.google.protobuf.ByteString
    getMethodNameBytes();

    /**
     * <code>optional string parameters = 4;</code>
     */
    java.lang.String getParameters();

    /**
     * <code>optional string parameters = 4;</code>
     */
    com.google.protobuf.ByteString
    getParametersBytes();

    /**
     * <code>optional int64 version = 5;</code>
     */
    long getVersion();
}
