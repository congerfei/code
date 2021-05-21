package com.xl.test.collection.array;

import java.util.Arrays;

/**
 * Author: xl
 * date :2020/12/11 10:53
 * description: 数组：数组是用于储存多个相同类型数据的集合。
 *              特性：不可变 （属性：length）
 *
 *              不用的数组就浪费了
 *              超过10的个数，又放不下 ----------引入集合的概念
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ArrrayTest2 {

    public static void main(String[] args) {

        int[] arr = new int[5];//定义一个大小为5的数组，存放的数据是int类型，并数组中的值都有默认值
        //如果只定义了引用不开辟堆内存空间，却去使用就会报错 NullPointerException”异常

        //避免使用数组的时候出现越界异常，java1.5版本后建议使用foreach
        for (int i : arr) {
            System.out.print(i);
        }

        System.out.println(Arrays.toString(arr));

    }

}
