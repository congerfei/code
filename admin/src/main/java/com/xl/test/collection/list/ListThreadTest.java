package com.xl.test.collection.list;

import java.util.ArrayList;
import java.util.UUID;

/**
 * 测试下List线程不安全问题   出现如下结果，甚至抛出异常了（并发修改异常--读取的时候其他线程在添加）
 *
 *
 [b54a4fac, 9e04f18d, 9dffc31b, 8b6cc277, b07d2211]
 [b54a4fac, 9e04f18d, 9dffc31b, 8b6cc277, b07d2211, 7d1dcfb1, a9b5e578, 38357e46, f45c4b15]
 [b54a4fac, 9e04f18d, 9dffc31b, 8b6cc277, b07d2211, 7d1dcfb1, a9b5e578]
 [b54a4fac, 9e04f18d, 9dffc31b, 8b6cc277, b07d2211, 7d1dcfb1]
 [b54a4fac, 9e04f18d, 9dffc31b, 8b6cc277, b07d2211]
 [b54a4fac, 9e04f18d, 9dffc31b, 8b6cc277, b07d2211]
 [b54a4fac, 9e04f18d, 9dffc31b, 8b6cc277, b07d2211]
 Exception in thread "0" Exception in thread "8" Exception in thread "5" java.util.ConcurrentModificationException  ----翻译过来就是并发修改异常

 */
public class ListThreadTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        //创建10个线程，并使用i给线程命名，线程启动后都是向集合中写入数据，然后读取出来
        for (int i = 0; i < 10 ; i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

}
