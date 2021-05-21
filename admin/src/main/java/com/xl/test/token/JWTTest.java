package com.xl.test.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Author: xl
 * date :2020/8/25 17:05
 * description:  token的创建和解析
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class JWTTest {

    public static void main(String[] args) {
        //用户登录，获取数据库用户表的信息
        //假如用户id：1
        JwtBuilder builder = Jwts.builder()
                //设置用户id
                .setId("13714858284")
                //设置主题（这个主题是干什么用的？，也可以不设置，感觉可以放其他重要的信息）
                .setSubject("congerfei")
                //设置创建时间
                .setIssuedAt(new Date())
                //设置过期时间
                .setExpiration(new Date(new Date().getTime() + 60000))
                //设置角色名称
                .claim("roles","admin")
                //自定义key(可以理解为解密的钥匙一般在配置文件里面)
                .signWith(SignatureAlgorithm.HS256, "bwcyguil");
        //用户登录之后，返回给前端token
        System.out.println("token..."+builder.compact());

        //前端请求带着token，后端解析
        Claims claims=Jwts.parser().setSigningKey("bwcyguil").parseClaimsJws(builder.compact()).getBody();
        //获取用户id
        System.out.println("id:"+claims.getId());
        //获取主题
        System.out.println("subject:"+claims.getSubject());
        //获取token创建时间（格式化时间引的jar为org.joda.time.DateTime）
        System.out.println("IssuedAt:"+ new DateTime(claims.getIssuedAt()).toString("yyyy-MM-dd HH:mm:ss"));
        //获取角色名称
        System.out.println("roles:"+claims.get("roles"));


    }


}
