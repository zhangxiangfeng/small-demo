package cn.openread.demo.study;

/**
 * 细节解析 @see https://mp.weixin.qq.com/s/h0yHjzouYuUK8Kt_9s4XlQ
 */
public class SimpleTest {

//
//    public static void main(String args[]) {
//        Integer a = 2;
//        set(a);
//        System.out.println(a);
//    }
//
//    public static void set(Integer aa) {
//        aa = aa + 1;
//    }

//    public static void main(String args[]){
//        String [] array=new String[]{"1","2"};
//        List<String> strings = Arrays.asList(array);
//        strings.add("3");
//        System.out.println(strings.size());
//    }

//    public static void main(String args[]) {
//        List<String> list = new ArrayList<>();
//        String r = "1";
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("1");
//        for (String s : list) {
//            if (r.equals(s)) {
//                list.remove(s);
//            }
//        }
//
//    }

//    public static void main(String args[]){
//        String path="D:\\simon-projects\\labs\\small-demo\\out\\1\\22\\33";
//        new File(path).mkdir();
//
//        new File(path).mkdirs();
//    }

//    public static void main(String args[]) {
//        float a = 200000.8f;
//        float b = 170000.5f;
//        System.out.println(BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b)));
//    }

//
//    public static void main(String args[]) {
//        Callable<User> oneCallable = new SomeCallable<>();
//        //由Callable<Integer>创建一个FutureTask<Integer>对象：
//        FutureTask<User> oneTask = new FutureTask<User>(oneCallable);
//        //注释：FutureTask<Integer>是一个包装器，它通过接受Callable<Integer>来创建，它同时实现了Future和Runnable接口。
//        //由FutureTask<Integer>创建一个Thread对象：
//        Thread oneThread = new Thread(oneTask);
//         oneThread.start();
//        //至此，一个线程就创建完成了。
//    }
//
//    class User {
//        int age = 19;
//    }
//
//    static class SomeCallable<User> implements Callable<SimpleTest.User> {
//
//        @Override
//        public SimpleTest.User call() throws Exception {
//            // TODO Auto-generated method stub
//            System.out.println(1);
//            return null;
//        }
//
//    }


//    public static void main(String[] args) throws ExecutionException,
//            InterruptedException {
//        System.out.println("----程序开始运行----");
//        Date date1 = new Date();
//
//        int taskSize = 5;
//        // 创建一个线程池
//        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
//        // 创建多个有返回值的任务
//        List<Future> list = new ArrayList<Future>();
//        for (int i = 0; i < taskSize; i++) {
//            Callable c = new MyCallable(i + " ");
//            // 执行任务并获取Future对象
//            Future f = pool.submit(c);
//            // System.out.println(">>>" + f.get().toString());
//            list.add(f);
//        }
//        // 关闭线程池
//        pool.shutdown();
//
//        // 获取所有并发任务的运行结果
//        for (Future f : list) {
//            // 从Future对象上获取任务的返回值，并输出到控制台
//            System.out.println(">>>" + f.get().toString());
//        }
//
//
//        Date date2 = new Date();
//        System.out.println("----程序结束运行----，程序运行时间【"
//                + (date2.getTime() - date1.getTime()) + "毫秒】");
//    }
//
//    static class MyCallable implements Callable<Object> {
//        private String taskNum;
//
//        MyCallable(String taskNum) {
//            this.taskNum = taskNum;
//        }
//
//        public Object call() throws Exception {
//            System.out.println(">>>" + taskNum + "任务启动");
//            Date dateTmp1 = new Date();
//            Thread.sleep(1000);
//            Date dateTmp2 = new Date();
//            long time = dateTmp2.getTime() - dateTmp1.getTime();
//            System.out.println(">>>" + taskNum + "任务终止");
//            return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
//
//        }
//    }

//    public static final int a = Integer.MAX_VALUE;
//    public static final int b = a - 2;
//
//    //
//    public static void main(String args[]){
//        for (int i =b ; i <= a; i++) {
//            System.out.println(i);
//        }
//    }

    public static void main(String args[]) {
        System.out.println(test());
    }

    public static boolean test() {
        try {
            System.out.println(1);
            return true;
        } catch (Exception e) {
            return true;
        } finally {
            System.out.println(2);
            return false;
        }
    }

}

