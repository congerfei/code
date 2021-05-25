package com.xl.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 *   对象 === json
 */
public class JsonTest02 {

    @Test
    public void test(){

    }

    /**
     *      JSON.toJSONString() 将 Java 对象转换换为 json串
     */
    @Test
    public void test1(){
        Person person = new Person(15, "小明", new Date());
        System.out.println(person.toString()); //Person(age=15, fullName=小明, dateOfBirth=Tue May 25 16:17:56 CST 2021)

        String s = JSON.toJSONString(person);
        System.out.println(s); // {"AGE":15,"DATE OF BIRTH":1621930732801,"FULL NAME":"小明"}

        //添加一个属性试试
        JSONObject obj = JSON.parseObject(s);
        obj.put("sex","男");
        System.out.println(obj); //{"DATE OF BIRTH":1621931224890,"FULL NAME":"小明","sex":"男","AGE":15}

        //多加了一个字段解析试试-----------并不影响，多的直接舍弃了
        Person newPerson = JSON.parseObject(obj.toString(), Person.class);
        System.out.println(newPerson);

    }
}
