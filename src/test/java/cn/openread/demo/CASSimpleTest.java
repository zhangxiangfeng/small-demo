package cn.openread.demo;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 核心介绍三个主要内容：
 * <p>
 * 1.什么是CAS操作
 * 2.CAS操作原理
 * 3.CAS操作中的ABA问题以及如何处理？
 * <p>
 * 从思想上来说:
 * 1.Synchronized属于悲观锁，悲观地认为程序中的并发情况严重，所以严防死守。
 * 2.CAS属于乐观锁，乐观地认为程序中的并发情况不那么严重，所以让线程不断去尝试更新。
 * <p>
 * ABA问题
 * <p>
 * 1 获取A 更新 B  1成功
 * 2 获取A 更新 B  2卡住->4成功
 * 3 获取B 更新 A  3成功
 * 最后 A-B>A
 */
public class CASSimpleTest {

    private static int count = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(20, 0);

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    synchronized (CASSimpleTest.class) {
                        count++;
                    }
                }
            }).start();
        }
        Thread.sleep(2000);
        System.err.println(count);
    }

    @Test
    public void test1() throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    atomicInteger.incrementAndGet();
                }
            }).start();
        }
        Thread.sleep(2000);
        System.err.println(atomicInteger);
    }

    @Test
    public void tes2t() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            final int stamp = money.getStamp();
            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    money.compareAndSet(money.getReference(), money.getReference() + 20, stamp, stamp + 1);
                }
            }).start();
        }
        Thread.sleep(2000);
        System.err.println(money.getReference());

    }

}
