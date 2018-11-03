package cn.openread.demo.final_study;

public class Test {
    public static void main(String[] args) {

    }

    public void test(final int a) {
        new Thread() {
            public void run() {
                System.out.println(a);
            }

            ;
        }.start();
    }
}
