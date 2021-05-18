package com.xl.admin.util.json;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;


public class JsonAnalysis {

    /**
     * json套json
     * {
     *     "842": {
     *         "useranswer": "3407|3408",
     *         "score": 0
     *     },
     *     "846": {
     *         "useranswer": "3414",
     *         "score": 0
     *     },
     *     "847": {
     *         "useranswer": "3499",
     *         "score": 2
     *     }
     * }
     */
    @Test
    public void test1(){
        String jsonStr="{\"842\":{\"useranswer\":\"3407|3408\",\"score\":0},\"846\":{\"useranswer\":\"3414\",\"score\":0},\"847\":{\"useranswer\":\"3499\",\"score\":2}}";
        //先将这条数据解析为JSONObject
        JSONObject json = JSONObject.parseObject(jsonStr);

        //其他都是解析成map的key-value的值
        Object o =json.get("848");
        System.out.println(o);

    }



}
