package cn.openread.demo.rpc.v1_2;


import cn.openread.demo.rpc.v1.SerializerFactory;
import cn.openread.demo.rpc.v1_1.NettyClient;

public class RpcDemoClient {

    public static void main(String[] args) throws Exception {
        NettyClient client = new NettyClient();
        client.init("127.0.0.1", 8080, SerializerFactory.getSerializer());

        CalculatorService proxy = ProxyFactory.getProxy(CalculatorService.class, client);

        System.out.println(proxy.add(1.0, 2.0));

        client.close();

    }

}
