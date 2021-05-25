package com.xl.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * <dependency>
 *     <groupId>com.alibaba</groupId>
 *     <artifactId>fastjson</artifactId>
 *     <version>1.2.47</version>
 * </dependency>
 *
 * fastjson 测试         parse (对句子)作语法分析; 作句法分析;
 *
 */
public class JsonTest01 {

    /**
     *  获取一个json对象的所有key ，并通过key获取值
     */
    @Test
    public void test() {
        String str = "{\"name\":\"小明\",\"sex\":\"男\",\"age\":20}";
        JSONObject jsonObject = JSON.parseObject(str);//需要传入标准的json串，即不能是单引号，需要双引号，记得使用\转义一下

        //获取json串的所有key
        Iterator sIterator = jsonObject.keySet().iterator();
        while (sIterator.hasNext()) {
            String key = (String) sIterator.next();
            System.out.print(key+"\t");

            //获得key值对应的value
            String value = jsonObject.getString(key);
            System.out.print(value+"\t");
        }


    }


    /**
     *      从 Java 变量到 JSON 对象
     */
   @Test
   public void test1(){

        JSONObject object = new JSONObject();
        //string
        object.put("string","string");
        //int
        object.put("int",2);
        //boolean
        object.put("boolean",true);
        //array
        List<Integer> integers = Arrays.asList(1,2,3);
        object.put("list",integers);
        //null
        object.put("null",null);

        System.out.println(object); //{"boolean":true,"string":"string","list":[1,2,3],"int":2}

   }

    /**
     *    从 JSON 对象到 Java 变量的解码  ,
     *    通过key的值一个一个解析,
     *    注意写法，字符串是带双引号的
     */

    @Test
   public void test2(){
        JSONObject object = JSONObject
                .parseObject("{\"boolean\":true,\"string\":\"string\",\"list\":[1,2,3],\"int\":2}");//里面可以用单引号，但是用双引号就要使用转义了
        //string
        String s = object.getString("string");
        System.out.println(s);
        //int
        int i = object.getIntValue("int");
        System.out.println(i);
        //boolean
        boolean b = object.getBooleanValue("boolean");
        System.out.println(b);
        //list
        List<Integer> integers = JSON.parseArray(object.getJSONArray("list").toJSONString(),Integer.class);
        System.out.println(integers.toString());
        //null
        System.out.println(object.getString("null"));
   }

    /**
     *  JSON 对象与字符串的相互转化
     */
    @Test
    public void test3(){
        //从字符串解析JSON对象
        JSONObject obj = JSON.parseObject("{\"runoob\":\"菜鸟教程\"}");
        //从字符串解析JSON数组
        JSONArray arr = JSON.parseArray("[\"菜鸟教程\",\"RUNOOB\"]\n");
        //将JSON对象转化为字符串
        String objStr = JSON.toJSONString(obj);
        //将JSON数组转化为字符串
        String arrStr = JSON.toJSONString(arr);

    }



}
