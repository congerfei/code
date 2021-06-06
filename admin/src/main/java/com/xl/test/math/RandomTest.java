package com.xl.test.math;

import java.util.Random;

/**
 * Author: xl
 * date :2020/12/9 11:19
 * description:二、java.util.Random 讲解
 *              N位数随机数   生成7位数字符串,随机数不足前面补0
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class RandomTest {

    public static void main(String[] args) {
//        Random()的两种构造方法：
//        Random()：创建一个新的随机数生成器。 默认当前系统时间的毫秒数作为种子数:
//        Random(long seed)：使用单个 long 种子创建一个新的随机数生成器。 对于种子相同的Random对象，生成的随机数序列是一样的。
        Random random = new Random();
        //Random.nextInt()方法，是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n,
//        for (int i =0;i<1000;i++) {
//            int i1 = random.nextInt(9999999);
//            if (i1<1000000){
//                System.out.println("第"+i+"次:"+i1);
//            }
//        }

        //如何确保生成的是7位数呢?
        String num = random.nextInt(9999999)+"";
        StringBuffer sb = new StringBuffer();
        System.out.println(sb);
        for(int i =0;i<7-num.length();i++){ //如果小于7位
            sb.append("0");
        }
        num = sb.toString()+num;//前面补0
        System.out.println(num);



//        protected int next(int bits)：生成下一个伪随机数。
//        boolean nextBoolean()：返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的boolean值。
//        void nextBytes(byte[] bytes)：生成随机字节并将其置于用户提供的 byte 数组中。
//        double nextDouble()：返回下一个伪随机数，它是取自此随机数生成器序列的、在0.0和1.0之间均匀分布的 double值。
//        float nextFloat()：返回下一个伪随机数，它是取自此随机数生成器序列的、在0.0和1.0之间均匀分布float值。
//        double nextGaussian()：返回下一个伪随机数，它是取自此随机数生成器序列的、呈高斯（“正态”）分布的double值，其平均值是0.0标准差是1.0。
//        int nextInt()：返回下一个伪随机数，它是此随机数生成器的序列中均匀分布的 int 值。
//        int nextInt(int n)：返回一个伪随机数，它是取自此随机数生成器序列的、在（包括和指定值（不包括）之间均匀分布的int值。
//        long nextLong()：返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的 long 值。
//        void setSeed(long seed)：使用单个 long 种子设置此随机数生成器的种子。

    }


}
