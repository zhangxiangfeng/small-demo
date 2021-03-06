// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.openread.demo.netty.proto.rpc;

/**
 * Protobuf type {@code cn.openread.demo.netty.proto.rpc.RPCRequest}
 */
public final class RPCRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:cn.openread.demo.netty.proto.rpc.RPCRequest)
        RPCRequestOrBuilder {
    public static final int ID_FIELD_NUMBER = 1;
    public static final int SERVICENAME_FIELD_NUMBER = 2;
    public static final int METHODNAME_FIELD_NUMBER = 3;
    public static final int PARAMETERS_FIELD_NUMBER = 4;
    public static final int VERSION_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:cn.openread.demo.netty.proto.rpc.RPCRequest)
    private static final cn.openread.demo.netty.proto.rpc.RPCRequest DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<RPCRequest>
            PARSER = new com.google.protobuf.AbstractParser<RPCRequest>() {
        public RPCRequest parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new RPCRequest(input, extensionRegistry);
        }
    };

    static {
        DEFAULT_INSTANCE = new cn.openread.demo.netty.proto.rpc.RPCRequest();
    }

    private long id_;
    private volatile java.lang.Object serviceName_;
    private volatile java.lang.Object methodName_;
    private volatile java.lang.Object parameters_;
    private long version_;
    private byte memoizedIsInitialized = -1;

    // Use RPCRequest.newBuilder() to construct.
    private RPCRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private RPCRequest() {
        id_ = 0L;
        serviceName_ = "";
        methodName_ = "";
        parameters_ = "";
        version_ = 0L;
    }

    private RPCRequest(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        int mutable_bitField0_ = 0;
        try {
            boolean done = false;
            while (!done) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        done = true;
                        break;
                    default: {
                        if (!input.skipField(tag)) {
                            done = true;
                        }
                        break;
                    }
                    case 8: {

                        id_ = input.readInt64();
                        break;
                    }
                    case 18: {
                        java.lang.String s = input.readStringRequireUtf8();

                        serviceName_ = s;
                        break;
                    }
                    case 26: {
                        java.lang.String s = input.readStringRequireUtf8();

                        methodName_ = s;
                        break;
                    }
                    case 34: {
                        java.lang.String s = input.readStringRequireUtf8();

                        parameters_ = s;
                        break;
                    }
                    case 40: {

                        version_ = input.readInt64();
                        break;
                    }
                }
            }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(
                    e).setUnfinishedMessage(this);
        } finally {
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return cn.openread.demo.netty.proto.rpc.Rpc.internal_static_cn_openread_demo_netty_proto_rpc_RPCRequest_descriptor;
    }

    public static cn.openread.demo.netty.proto.rpc.RPCRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static cn.openread.demo.netty.proto.rpc.RPCRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static cn.openread.demo.netty.proto.rpc.RPCRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static cn.openread.demo.netty.proto.rpc.RPCRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static cn.openread.demo.netty.proto.rpc.RPCRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static cn.openread.demo.netty.proto.rpc.RPCRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static cn.openread.demo.netty.proto.rpc.RPCRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static cn.openread.demo.netty.proto.rpc.RPCRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static cn.openread.demo.netty.proto.rpc.RPCRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static cn.openread.demo.netty.proto.rpc.RPCRequest parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(cn.openread.demo.netty.proto.rpc.RPCRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static cn.openread.demo.netty.proto.rpc.RPCRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<RPCRequest> parser() {
        return PARSER;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return cn.openread.demo.netty.proto.rpc.Rpc.internal_static_cn_openread_demo_netty_proto_rpc_RPCRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        cn.openread.demo.netty.proto.rpc.RPCRequest.class, cn.openread.demo.netty.proto.rpc.RPCRequest.Builder.class);
    }

    /**
     * <code>optional int64 id = 1;</code>
     */
    public long getId() {
        return id_;
    }

    /**
     * <code>optional string serviceName = 2;</code>
     */
    public java.lang.String getServiceName() {
        java.lang.Object ref = serviceName_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            serviceName_ = s;
            return s;
        }
    }

    /**
     * <code>optional string serviceName = 2;</code>
     */
    public com.google.protobuf.ByteString
    getServiceNameBytes() {
        java.lang.Object ref = serviceName_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
            serviceName_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    /**
     * <code>optional string methodName = 3;</code>
     */
    public java.lang.String getMethodName() {
        java.lang.Object ref = methodName_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            methodName_ = s;
            return s;
        }
    }

    /**
     * <code>optional string methodName = 3;</code>
     */
    public com.google.protobuf.ByteString
    getMethodNameBytes() {
        java.lang.Object ref = methodName_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
            methodName_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    /**
     * <code>optional string parameters = 4;</code>
     */
    public java.lang.String getParameters() {
        java.lang.Object ref = parameters_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            parameters_ = s;
            return s;
        }
    }

    /**
     * <code>optional string parameters = 4;</code>
     */
    public com.google.protobuf.ByteString
    getParametersBytes() {
        java.lang.Object ref = parameters_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
            parameters_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    /**
     * <code>optional int64 version = 5;</code>
     */
    public long getVersion() {
        return version_;
    }

    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;

        memoizedIsInitialized = 1;
        return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (id_ != 0L) {
            output.writeInt64(1, id_);
        }
        if (!getServiceNameBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 2, serviceName_);
        }
        if (!getMethodNameBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 3, methodName_);
        }
        if (!getParametersBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 4, parameters_);
        }
        if (version_ != 0L) {
            output.writeInt64(5, version_);
        }
    }

    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (id_ != 0L) {
            size += com.google.protobuf.CodedOutputStream
                    .computeInt64Size(1, id_);
        }
        if (!getServiceNameBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, serviceName_);
        }
        if (!getMethodNameBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, methodName_);
        }
        if (!getParametersBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, parameters_);
        }
        if (version_ != 0L) {
            size += com.google.protobuf.CodedOutputStream
                    .computeInt64Size(5, version_);
        }
        memoizedSize = size;
        return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cn.openread.demo.netty.proto.rpc.RPCRequest)) {
            return super.equals(obj);
        }
        cn.openread.demo.netty.proto.rpc.RPCRequest other = (cn.openread.demo.netty.proto.rpc.RPCRequest) obj;

        boolean result = true;
        result = result && (getId()
                == other.getId());
        result = result && getServiceName()
                .equals(other.getServiceName());
        result = result && getMethodName()
                .equals(other.getMethodName());
        result = result && getParameters()
                .equals(other.getParameters());
        result = result && (getVersion()
                == other.getVersion());
        return result;
    }

    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptorForType().hashCode();
        hash = (37 * hash) + ID_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                getId());
        hash = (37 * hash) + SERVICENAME_FIELD_NUMBER;
        hash = (53 * hash) + getServiceName().hashCode();
        hash = (37 * hash) + METHODNAME_FIELD_NUMBER;
        hash = (53 * hash) + getMethodName().hashCode();
        hash = (37 * hash) + PARAMETERS_FIELD_NUMBER;
        hash = (53 * hash) + getParameters().hashCode();
        hash = (37 * hash) + VERSION_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                getVersion());
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE
                ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        Builder builder = new Builder(parent);
        return builder;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RPCRequest> getParserForType() {
        return PARSER;
    }

    public cn.openread.demo.netty.proto.rpc.RPCRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /**
     * Protobuf type {@code cn.openread.demo.netty.proto.rpc.RPCRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:cn.openread.demo.netty.proto.rpc.RPCRequest)
            cn.openread.demo.netty.proto.rpc.RPCRequestOrBuilder {
        private long id_;
        private java.lang.Object serviceName_ = "";
        private java.lang.Object methodName_ = "";
        private java.lang.Object parameters_ = "";
        private long version_;

        // Construct using cn.openread.demo.netty.proto.rpc.RPCRequest.newBuilder()
        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            maybeForceBuilderInitialization();
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return cn.openread.demo.netty.proto.rpc.Rpc.internal_static_cn_openread_demo_netty_proto_rpc_RPCRequest_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return cn.openread.demo.netty.proto.rpc.Rpc.internal_static_cn_openread_demo_netty_proto_rpc_RPCRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            cn.openread.demo.netty.proto.rpc.RPCRequest.class, cn.openread.demo.netty.proto.rpc.RPCRequest.Builder.class);
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3
                    .alwaysUseFieldBuilders) {
            }
        }

        public Builder clear() {
            super.clear();
            id_ = 0L;

            serviceName_ = "";

            methodName_ = "";

            parameters_ = "";

            version_ = 0L;

            return this;
        }

        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return cn.openread.demo.netty.proto.rpc.Rpc.internal_static_cn_openread_demo_netty_proto_rpc_RPCRequest_descriptor;
        }

        public cn.openread.demo.netty.proto.rpc.RPCRequest getDefaultInstanceForType() {
            return cn.openread.demo.netty.proto.rpc.RPCRequest.getDefaultInstance();
        }

        public cn.openread.demo.netty.proto.rpc.RPCRequest build() {
            cn.openread.demo.netty.proto.rpc.RPCRequest result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        public cn.openread.demo.netty.proto.rpc.RPCRequest buildPartial() {
            cn.openread.demo.netty.proto.rpc.RPCRequest result = new cn.openread.demo.netty.proto.rpc.RPCRequest(this);
            result.id_ = id_;
            result.serviceName_ = serviceName_;
            result.methodName_ = methodName_;
            result.parameters_ = parameters_;
            result.version_ = version_;
            onBuilt();
            return result;
        }

        public Builder clone() {
            return (Builder) super.clone();
        }

        public Builder setField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                Object value) {
            return (Builder) super.setField(field, value);
        }

        public Builder clearField(
                com.google.protobuf.Descriptors.FieldDescriptor field) {
            return (Builder) super.clearField(field);
        }

        public Builder clearOneof(
                com.google.protobuf.Descriptors.OneofDescriptor oneof) {
            return (Builder) super.clearOneof(oneof);
        }

        public Builder setRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                int index, Object value) {
            return (Builder) super.setRepeatedField(field, index, value);
        }

        public Builder addRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                Object value) {
            return (Builder) super.addRepeatedField(field, value);
        }

        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof cn.openread.demo.netty.proto.rpc.RPCRequest) {
                return mergeFrom((cn.openread.demo.netty.proto.rpc.RPCRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(cn.openread.demo.netty.proto.rpc.RPCRequest other) {
            if (other == cn.openread.demo.netty.proto.rpc.RPCRequest.getDefaultInstance()) return this;
            if (other.getId() != 0L) {
                setId(other.getId());
            }
            if (!other.getServiceName().isEmpty()) {
                serviceName_ = other.serviceName_;
                onChanged();
            }
            if (!other.getMethodName().isEmpty()) {
                methodName_ = other.methodName_;
                onChanged();
            }
            if (!other.getParameters().isEmpty()) {
                parameters_ = other.parameters_;
                onChanged();
            }
            if (other.getVersion() != 0L) {
                setVersion(other.getVersion());
            }
            onChanged();
            return this;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            cn.openread.demo.netty.proto.rpc.RPCRequest parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (cn.openread.demo.netty.proto.rpc.RPCRequest) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        /**
         * <code>optional int64 id = 1;</code>
         */
        public long getId() {
            return id_;
        }

        /**
         * <code>optional int64 id = 1;</code>
         */
        public Builder setId(long value) {

            id_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>optional int64 id = 1;</code>
         */
        public Builder clearId() {

            id_ = 0L;
            onChanged();
            return this;
        }

        /**
         * <code>optional string serviceName = 2;</code>
         */
        public java.lang.String getServiceName() {
            java.lang.Object ref = serviceName_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                serviceName_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>optional string serviceName = 2;</code>
         */
        public Builder setServiceName(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            serviceName_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>optional string serviceName = 2;</code>
         */
        public com.google.protobuf.ByteString
        getServiceNameBytes() {
            java.lang.Object ref = serviceName_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                serviceName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>optional string serviceName = 2;</code>
         */
        public Builder setServiceNameBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            serviceName_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>optional string serviceName = 2;</code>
         */
        public Builder clearServiceName() {

            serviceName_ = getDefaultInstance().getServiceName();
            onChanged();
            return this;
        }

        /**
         * <code>optional string methodName = 3;</code>
         */
        public java.lang.String getMethodName() {
            java.lang.Object ref = methodName_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                methodName_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>optional string methodName = 3;</code>
         */
        public Builder setMethodName(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            methodName_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>optional string methodName = 3;</code>
         */
        public com.google.protobuf.ByteString
        getMethodNameBytes() {
            java.lang.Object ref = methodName_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                methodName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>optional string methodName = 3;</code>
         */
        public Builder setMethodNameBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            methodName_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>optional string methodName = 3;</code>
         */
        public Builder clearMethodName() {

            methodName_ = getDefaultInstance().getMethodName();
            onChanged();
            return this;
        }

        /**
         * <code>optional string parameters = 4;</code>
         */
        public java.lang.String getParameters() {
            java.lang.Object ref = parameters_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                parameters_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>optional string parameters = 4;</code>
         */
        public Builder setParameters(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            parameters_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>optional string parameters = 4;</code>
         */
        public com.google.protobuf.ByteString
        getParametersBytes() {
            java.lang.Object ref = parameters_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                parameters_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>optional string parameters = 4;</code>
         */
        public Builder setParametersBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            parameters_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>optional string parameters = 4;</code>
         */
        public Builder clearParameters() {

            parameters_ = getDefaultInstance().getParameters();
            onChanged();
            return this;
        }

        /**
         * <code>optional int64 version = 5;</code>
         */
        public long getVersion() {
            return version_;
        }

        /**
         * <code>optional int64 version = 5;</code>
         */
        public Builder setVersion(long value) {

            version_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>optional int64 version = 5;</code>
         */
        public Builder clearVersion() {

            version_ = 0L;
            onChanged();
            return this;
        }

        public final Builder setUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return this;
        }

        public final Builder mergeUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return this;
        }


        // @@protoc_insertion_point(builder_scope:cn.openread.demo.netty.proto.rpc.RPCRequest)
    }

}

