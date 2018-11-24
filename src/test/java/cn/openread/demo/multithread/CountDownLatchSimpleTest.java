package cn.openread.demo.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
 * <p>
 * CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 *
 * @see http://www.importnew.com/21889.html
 * 主线程等待子线程执行完毕，再执行
 */
public class CountDownLatchSimpleTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
