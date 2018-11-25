package cn.openread.demo.rpc.v1;

public interface Serializer {

    public <T> Object deserialize(byte[] bytes, Class<T> clazz);

    public <T> byte[] serialize(T obj);
}
