package cn.openread.demo;

import cn.openread.demo.disruptor.LongEvent;
import cn.openread.demo.disruptor.LongEventFactory;
import cn.openread.demo.disruptor.LongEventHandler;
import cn.openread.demo.disruptor.LongEventProducer;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleTest {

    @Test
    public void test21() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Farther farther = new Farther();
        farther.sing();
        System.out.println("=======================");
        Children children = new Children();
        children.sing();
//        farther = children;
//        farther.sing();
    }

    static class Farther {

        static {
            System.out.println("Farther static init");
        }

        {
            System.out.println("Farther no static init");
        }

        public Farther() {
            System.out.println("Farther  init");
        }

        public static void dance() {
            System.out.println("Farther  dance");
        }

        private void sing() {
            System.out.println(this.getClass() + " 会 sing");
        }
    }

    static class Children extends Farther {
        static {
            System.out.println("Children static init");
        }

        {
            System.out.println("Children no static init");
        }

        public Children() {
            System.out.println("Children  init");
        }

        private void sing() {
            System.out.println(this.getClass() + " 会 sing");
            Farther.dance();
        }
    }


    @Test
    public void test331() throws IOException {
        Runtime.getRuntime().exec("");
    }


    @Test
    public void test33() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 2100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(1);
                }
            });
        }
        Thread.sleep(50000L);

    }

    @Test
    public void test() {
        Long s = System.currentTimeMillis();
        //创建缓冲池
        ExecutorService executor = Executors.newFixedThreadPool(12);
        //创建工厂
        LongEventFactory factory = new LongEventFactory();
        //创建bufferSize ,也就是RingBuffer大小，必须是2的N次方
        int ringBufferSize = 1024 * 1024; //

        /**
         //BlockingWaitStrategy 是最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现
         WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
         //SleepingWaitStrategy 的性能表现跟BlockingWaitStrategy差不多，对CPU的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景
         WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
         //YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于CPU逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性
         WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();
         */


        /**
         *  参数说明：
         */

        //创建disruptor
        Disruptor<LongEvent> disruptor =
                new Disruptor<LongEvent>(factory, ringBufferSize, DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new YieldingWaitStrategy());
        // 连接消费事件方法
        disruptor.handleEventsWith(new LongEventHandler());

        // 启动
        disruptor.start();

        //Disruptor 的事件发布过程是一个两阶段提交的过程：
        //发布事件
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);
        //LongEventProducerWithTranslator producer = new LongEventProducerWithTranslator(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (long l = 0; l < 1000000; l++) {
            byteBuffer.putLong(0, l);
            producer.onData(byteBuffer);
        }

        disruptor.shutdown();//关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
        executor.shutdown();//关闭 disruptor 使用的线程池；如果需要的话，必须手动关闭， disruptor 在 shutdown 时不会自动关闭；

        Long e = System.currentTimeMillis();
        System.out.println("耗时:" + (e - s));
    }

    /**
     * java.util.concurrent包下的新类。LinkedBlockingQueue就是其中之一，是一个阻塞的线程安全的队列，底层采用链表实现。
     * <p>
     * LinkedBlockingQueue构造的时候若没有指定大小，则默认大小为Integer.MAX_VALUE，当然也可以在构造函数的参数中指定大小。LinkedBlockingQueue不接受null。
     * <p>
     * 添加元素的方法有三个：add,put,offer,且这三个元素都是向队列尾部添加元素的意思。
     * <p>
     * 区别:
     * <p>
     * add方法在添加元素的时候，若超出了度列的长度会直接抛出异常：
     * <p>
     * put方法，若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素。
     * offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false。
     * <p>
     * 从队列中取出并移除头元素的方法有：poll，remove，take。
     * poll: 若队列为空，返回null。
     * <p>
     * remove:若队列为空，抛出NoSuchElementException异常。
     * <p>
     * take:若队列为空，发生阻塞，等待有元素。
     */
    @Test
    public void test2() {
        Long s = System.currentTimeMillis();
        LinkedBlockingQueue<LongEvent> queue = new LinkedBlockingQueue<>(1000000);


        ((Runnable) () -> {
            for (int i = 0; i < 1000000; i++) {
                LongEvent longEvent = new LongEvent();
                longEvent.setValue(i);
                queue.offer(longEvent);
            }
        }).run();


        ((Runnable) () -> {
            while (true) {
                LongEvent longEvent = queue.poll();
                if (longEvent == null) {
                    Long e = System.currentTimeMillis();
                    System.out.println("耗时:" + (e - s));
                    System.exit(0);
                }
                System.out.println("消费的数据:" + longEvent.getValue());
            }
        }).run();

        Long e = System.currentTimeMillis();
        System.out.println("耗时:" + (e - s));

    }
}
