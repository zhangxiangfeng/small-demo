package cn.openread.demo;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @see https://blog.csdn.net/u011080472/article/details/51332866
 * @see http://www.cnblogs.com/lanxuezaipiao/p/4138511.html
 * <p>
 * 加载类的开放性
 * <p>
 * 类加载是获取一个类的第一步，Java并没有规定应该怎么去获取？去哪里获取
 * 所以有很多方式
 * 1.压缩包
 * 2.网络
 * 3.动态代理
 * 4.其它文件生成例如JSP
 * <p>
 * <p>
 * 类加载器与类的唯一性
 * <p>
 * 不同类加载器加载出来同一个class文件那么他们也是不等的
 * <p>
 * 这里的“相等”，包括代表类的Class对象的equals()方法、isAssignableFrom()方法、isInstance()方法的返回结果，也包括使用instanceof关键字做对象所属关系判定等情况。
 * <p>
 * 那么什么是双亲委派？
 * 某个特定的类加载器在接到加载类的请求时，首先将加载任务委托给父类加载器，依次递归，如果父类加载器可以完成类加载任务，就成功返回；
 * 只有父类加载器无法完成此加载任务时，才自己去加载。
 */
public class ClassLoaderSimpleTest {


    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 自定义类加载器
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };


        // 使用ClassLoaderTest的类加载器加载本类
        Object obj1 = ClassLoaderSimpleTest.class.getClassLoader().loadClass("cn.openread.demo.ClassLoaderSimpleTest").newInstance();
        System.out.println(obj1.getClass());
        System.out.println(obj1 instanceof cn.openread.demo.ClassLoaderSimpleTest);


        // 使用自定义类加载器加载本类
        Object obj2 = myLoader.loadClass("cn.openread.demo.ClassLoaderSimpleTest").newInstance();
        System.out.println(obj2.getClass());
        System.out.println(obj2 instanceof cn.openread.demo.ClassLoaderSimpleTest);
    }
}
