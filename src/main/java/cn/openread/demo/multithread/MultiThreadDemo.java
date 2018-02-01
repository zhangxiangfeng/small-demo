package cn.openread.demo.multithread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现有10张票,有5个售票窗口,每个窗口售一张票需要2s.用Java实现整个卖票逻辑
 * 1.卖票过程中实时显示余票
 * 2.只有一台售票打印机
 */
public class MultiThreadDemo {

    private static int ticketNumber = 10;

    private static ReentrantLock reentrantLock = new ReentrantLock();


    private static void saleTicket(String name) throws InterruptedException {
        reentrantLock.lock();
        if (MultiThreadDemo.ticketNumber <= 0) {
            System.out.println("卖完了");
            System.exit(0);
        }
        System.out.println(String.format("%s 正在售票..", name));
        Thread.sleep(2000);
        MultiThreadDemo.ticketNumber = MultiThreadDemo.ticketNumber - 1;
        reentrantLock.unlock();
    }

    public static void main(String[] args) {

        MultiThreadDemo multiThreadDemo = new MultiThreadDemo();
        multiThreadDemo.run();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            Ticketer ticketer = new Ticketer("thread-sale", "thread-sale-" + (i + 1));
            ticketer.start();
        }
    }


    /**
     * 售票员
     */
    class Ticketer extends Thread {

        private String ticketerName;

        public Ticketer(String name, String ticketerName) {
            super(name);
            this.ticketerName = ticketerName;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    this.sale(this.ticketerName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 售票
         */
        public void sale(String name) throws InterruptedException {

            MultiThreadDemo.saleTicket(name);

            System.out.println(String.format("%s 售票成功，余票:%d", name, MultiThreadDemo.ticketNumber));
        }
    }


}
