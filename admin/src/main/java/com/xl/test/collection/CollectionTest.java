package com.xl.test.collection;

import java.util.*;

/**
 * Arrays.asList() 的输出作为一个 List ，但是这里的底层实现是数组，没法调整大小。如果尝试在这个 List 上调用 add() 或 remove()，由于这两个方法会尝试修改数组大小，所以会在运行时得到“Unsupported Operation（不支持的操作）”错误：
 */
public class CollectionTest {
        public static void main(String[] args) {
            //将有个数组转换成一个集合
            Collection<Integer> collection =
                    new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            Integer[] moreInts = { 6, 7, 8, 9, 10 };

            //新增一个集合到另一个集合
            collection.addAll(Arrays.asList(moreInts));

            //批量新增元素到集合
            Collections.addAll(collection, 11, 12, 13, 14, 15);
            Collections.addAll(collection, moreInts);
            // Produces a list "backed by" an array:
            List<Integer> list = Arrays.asList(16,17,18,19,20);
            list.set(1, 99); // OK -- modify an element
            // list.add(21); // Runtime error; the underlying
            // array cannot be resized.
        }
}
