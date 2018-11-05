package cn.openread.demo.final_study;

import org.junit.Test;

/**
 * 1、被final修饰的类不可以被继承
 * <p>
 * 2、被final修饰的方法不可以被重写
 * <p>
 * 3、被final修饰的变量不可以被改变
 * <p>
 * 重点就是第三句。被final修饰的变量不可以被改变，什么不可以被改变呢，
 * 1.是变量的引用？
 * 2.还是变量里面的内容？
 * 3还是两者都不可以被改变？
 */
public class FinalSimpleTest {

    public static void main(String[] args) {
        FinalString fs = new FinalString("");
        A(fs);
    }

    private static void A(final FinalString fs) {
        fs.setStr("123");
        FinalString fss = new FinalString("22");
//        fs = fss;
        System.out.println(fs.getStr());
    }

    /**
     * final编译期间会进行优化
     */
    @Test
    public void test() {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
    }


    @Test
    public void test3() {
        final String[] strs0 = {"123", "234"};
        final String[] strs1 = {"345", "456"};
//        strs1 = strs0;
        strs1[1] = "333";
        for (String s : strs1) {
            System.out.println(s);

        }
    }

    @Test
    public void test2() {
        final FinalString fs = new FinalString("1");
        final FinalString fss = new FinalString("333");
//        fs = fss;
    }

    @Test
    public void test1() {
        final FinalString fs = new FinalString("1");
        fs.setStr("2");
        System.out.println(fs.getStr());
    }

    /**
     * static和final关键字
     */
    @Test
    public void test0() {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);
    }

    /**
     * 为什么Java匿名内部类必须是final修饰
     * http://www.cnblogs.com/dolphin0520/p/3811445.html
     * 　当test方法执行完毕之后，变量a的生命周期就结束了，而此时Thread对象的生命周期很可能还没有结束，那么在Thread的run方法中继续访问变量a就变成不可能了，但是又要实现这样的效果，怎么办呢？
     * Java采用了 复制  的手段来解决这个问题。
     * <p>
     * 所谓复制：就是将一个变量copy两份，
     * 一份给匿名内部类实现
     * 一份给Thred
     * 但是又可能 匿名的run已经结束了，然而Thred依然在运行，造成值不一致的情况，所以采用final修饰
     * <p>
     * <p>
     * ===========================
     * String类为什么是final的
     * 1.安全：和本地系统交互，防止写漏洞，影响安全
     * 2.效率和性能，不可变，多线程安全，共享。所有被就会被final的jvm优化为内联函数，可以提高效率，JVM和Java应用都会缓存final变量
     * <p>
     * * 3 只有当字符串是不可变的，字符串池才有可能实现。字符串池的实现可以在运行时节约很多heap空间，因为不同的字符串变量都指向池中的同一个字符串。
     * * 如果字符串是可变的，那么会引起很严重的安全问题。因为字符串是不可变的，所以它的值是不可改变的，否则改变字符串指向的对象的值，造成安全漏洞。
     * * 4因为字符串是不可变的，所以是多线程安全的，同一个字符串实例可以被多个线程共享。这样便不用因为线程安全问题而使用同步。字符串自己便是线程安全的。
     * * 类加载器要用到字符串，不可变性提供了安全性，以便正确的类被加载。譬如你想加载java.sql.Connection类，而这个值被改成了myhacked.Connection，那么会对你的数据库造成不可知的破坏。
     * * 5.因为字符串是不可变的，所以在它创建的时候hashcode就被缓存了，不需要重新计算。这就使得字符串很适合作为Map中的键，字符串的处理速度要快过其它的键对象。这就是HashMap中的键往往都使用字符串。
     * *
     **/
    @Test
    public void test6() {
        final int a = 0;
        new Thread() {
            public void run() {
                System.out.println(a);
            }
        }.start();
    }

    /**
     * 1.在构造函数内对一个 final 域的写入，与随后把这个被构造对象的引用赋值给一个引用变量，这两个操作之间不能重排序。
     * 2.初次读一个包含 final 域的对象的引用，与随后初次读这个 final 域，这两个操作之间不能重排序。
     */
    static class FinalExample {
        static FinalExample obj;
        final int j;                      //final变量
        int i;                            //普通变量

        FinalExample(int j) {
            this.j = j;
        }

//        public void FinalExample() {     //构造函数
//            i = 1;                        //写普通域
//            j = 2;                        //写final域
//        }

        public static void writer() {    //写线程A执行
//            obj = new FinalExample(j);
        }

        public static void reader() {       //读线程B执行
            FinalExample object = obj;       //读对象引用
            int a = object.i;                //读普通域
            int b = object.j;                //读final域
        }
    }
}

class MyClass {
    public static double j = Math.random();
    public final double i = Math.random();
}

class FinalString {
    private String str;

    public FinalString(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}


