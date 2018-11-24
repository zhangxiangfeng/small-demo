源码分析

1. EventExecutorGroup里面有一个EventExecutor数组，保存了多个EventExecutor;
2. EventExecutorGroup是不干什么事情的，当收到一个请后，他就调用next()获得一个它里面的EventExecutor，再调用这个executor的方法；
3. next(): EventExecutorChooser.next()定义选择EventExecutor的策略； PowerOfTwoEventExecutorChooser和GenericEventExecutorChooser

    public EventExecutorChooser newChooser(EventExecutor[] executors) {
        if (isPowerOfTwo(executors.length)) {
            return new PowerOfTwoEventExecutorChooser(executors);
        } else {
            return new GenericEventExecutorChooser(executors);
        }
    }

    private static boolean isPowerOfTwo(int val) {
        return (val & -val) == val;
    }
4.  EventLoopGroup bossGroup = new NioEventLoopGroup(1);
这里指定1;指的是1个boss NioEnventLoop;配置多个多用也只会选择一个。但是如果绑定多个端口，启动多个它就有用了

5.结合图进行分析

Tips:

Netty的NioEventLoop:794 通过 rebuildSelector 解决JDK的select占用cpu 100% 的bug
