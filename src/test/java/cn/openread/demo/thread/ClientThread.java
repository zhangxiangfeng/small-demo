package cn.openread.demo.thread;

import java.util.Random;

public class ClientThread extends Thread {
    private static final Random random = new Random();
    /**
     * 是发送工作请求的类。发送工作请求这个行为对应的是实例程序中的一下处理：
     * 1创建request的实例
     * 2将该实例传递给Channel类的putRquest方法
     */
    private final Channel channel;

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);
                channel.putRequest(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Request {
    private static final Random random = new Random();
    /**
     * 是工作请求的类
     * name字段是发送请求的委托者，number是请求的编号。
     */
    private final String name;
    private final int number;

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "[ Request from " + name + " No. " + number + " ]";
    }
}

class Channel {
    /**
     * 是负责传递工作请求以及保存工人线程的类
     * 为了传递工作请求，我们Channel类中定义了requestQueue字段，该字段扮演保存请求队列的角色，putRequest方法用于将请求加入到队列中，takeRequest方法则用于取出后队列中的请求。
     * Channel类中定义了一个用于保存工人线程的threadPool字段。threadPool是WorkerThread的数组，Channel类的构造函数会初始化threadPool字段并创建WorkerThread的实例
     */
    private static final int MAX_REQUEST = 100;
    private final Request[] requestQueue;
    private final WorkerThread[] threadPool;
    private int tail; //下次putRequest的位置
    private int head; //下次takeRequest的位置
    private int count; //Request的数量

    public Channel(int threads) {
        this.requestQueue = new Request[MAX_REQUEST];
        this.tail = 0;
        this.head = 0;
        this.count = 0;

        threadPool = new WorkerThread[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    public void startWorkers() {
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].start();
        }
    }

    public synchronized void putRequest(Request request) {
        while (count >= requestQueue.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest() {
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        //同时唤醒其它线程
        notifyAll();
        return request;
    }

}

/**
 * @see https://blog.csdn.net/smartdt/article/details/79350970
 * <p>
 * Worker的意思是工作的人，在Worker Thread模式中，工人线程Worker thread会逐个取回工作并进行处理，当所有工作全部完成后，工人线程会等待新的工作到来。
 * <p>
 * Worker Thread模式也被成为Background Thread（背景线程）模式，另外，如果从保存多个工人线程的场所这一点看，我们也可以称这种模式为Thread Pool模式。
 */
class Main {
    /**
     * 会创建一个雇佣了五个工人线程的Channel实例，并将其共享给三个ClientThread实例
     *
     * @param args
     */
    public static void main(String[] args) {
        Channel channel = new Channel(5); //工人线程的个数
        channel.startWorkers();
        new ClientThread("Steve Nash", channel).start();
        new ClientThread("Michael Jordan", channel).start();
        new ClientThread("Ronaldo", channel).start();
    }
}

class WorkerThread extends Thread {
    /**
     * 是表示工人线程的类。
     * 1.调用takeRequest方法从Channel的实例中获取一个Request的实例
     * 2.调用Request的实例的execute方法。
     * 工人线程一旦启动后就会一直工作，也就是说，他会反复执行“获取一个新的Request的实例，然后调用它的execute方法”处理
     */
    private final Channel channel;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        while (true) {
            Request request = channel.takeRequest();
            request.execute();
        }
    }
}