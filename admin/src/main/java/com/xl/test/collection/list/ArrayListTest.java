package com.xl.test.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author: xl
 * date :2020/9/28 14:34
 * description:ArrayList详解
 * History:
 *    toArray()  以正确的顺序（从第一个到最后一个元素）返回一个包含此列表中所有元素的数组
 *    subList(int fromIndex,int toIndex)  返回此列表中指定的 fromIndex （包括）和 toIndex之间的独占视图
 *    size()  返回此列表中的元素数
 *    set(int index,E element)  用指定的元素替换此列表中指定位置的元素
 *    removeRange(int fromIndex,int toIndex)  从这个列表中删除所有索引在 fromIndex （含）和 toIndex之间的元素
 *    isEmpty()  如果此列表不包含元素，则返回true
 *    get(int index)  返回此列表中指定位置的元素，也就是说可以得到任何一个，但是得知道排第几个
 *    add(E element)  将指定的元素追加到此列表的末尾
 *    add(int index,E element)  在此列表中的指定位置插入指定的元素
 *    remove(int index)  删除该列表中指定位置的元素
 *    clear()  从列表中删除所有元素
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ArrayListTest {
    public static void main(String[] args) {

        //可以存放任何东西，这里用泛型控制一下，只存放Person
        List<Person> list= new ArrayList<>();

        Person p1 = new Person("张三", 22);
        Person p2 = new Person("李四", 23);
        Person p3 = new Person("王五", 18);
        //1.添加
        list.add(p1);
        list.add(p2);
        list.add(p3);


        // 第一种遍历方式：for循环
        for (int i = 0; i < list.size(); i++) {
            //2.取数  3.获取最大数量
            Person person = list.get(i);
            System.out.println(person);
        }
        System.out.println("----------------");
        // 第二种遍历方式：foreach
        for (Person person : list) {
            System.out.println(person);
        }



        Person p4 = new Person("刘六", 16);
        //4.插入一个，从第2个后面插入p4
        list.add(2,p4);


        System.out.println("----------------");
        // 第三种遍历方式：Iterator
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person);
        }
        System.out.println("----------------");







    }
}
