package com.xl.test.collection.list;

/**
 * Author: xl
 * date :2020/9/28 14:35
 * description:用于存进集合中
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Person {
    private String userName;
    private Integer userAge;

    public Person(String userName, Integer userAge) {
        super();
        this.userName = userName;
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "Person [userName=" + userName + ", userAge=" + userAge + "]";
    }

}
