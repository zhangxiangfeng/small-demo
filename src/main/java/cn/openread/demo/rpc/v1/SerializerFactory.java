package cn.openread.demo.rpc.v1;

import cn.openread.demo.rpc.v1.serialize.ProtobufSerializer;

public class SerializerFactory {

    public static Serializer getSerializer() {
        return new ProtobufSerializer();
    }

}
