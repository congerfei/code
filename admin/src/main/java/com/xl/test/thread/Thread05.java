package com.xl.test.thread;

import java.util.ArrayList;
import java.util.List;

/**
 *      2个线程之间如何通信呢？即获取同一资源？ 这里只演示方法一，其他的单独查资料
 *      方法一：添加volatile
 *      方式二：使用Object类的wait() 和 notify() 方法
 *      方式三：使用JUC工具类 CountDownLatch
 *      方式四：ReentrantLock 结合 Condition
 *      方式五：基本LockSupport实现线程间的阻塞和唤醒
 */
public class Thread05 {
    // 定义一个共享变量来实现通信，它需要是volatile修饰，否则线程不能及时感知
    static volatile boolean notice = false;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 实现线程A
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5)
                    notice = true;
            }
        });
        // 实现线程B
        Thread threadB = new Thread(() -> {
            while (true) {
                if (notice) {
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                    break;
                }
            }
        });
        //　需要先启动线程B
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 再启动线程A
        threadA.start();
    }

}
