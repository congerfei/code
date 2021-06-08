package com.xl.test.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

/**
 * HEADER：头部，头部主要是用来定义令牌签名使用的算法和令牌类型，是一个JSON串，需要使用Base64Url进行编码。
 * PAYLOAD：载荷，载荷主要用来存放传输的数据，是一个JSON串，需要使用Base64Url进行编码。
 * SIGNATURE：签名，根据你HEADER定义的算法类型，签名主要用于防止数据被篡改。
 */
public class JWTTest01 {
    /**
     *           生成token
     *
     * iss (issuer)：签发人
     * aud (audience)：接收者
     * sub (subject)：令牌描述
     * iat (Issued At)：签发时间
     * exp (expiration time)：过期时间
     * nbf (Not Before)：生效时间
     * jti (JWT ID)：令牌编号
     */
    @Test
    public void test01(){
        JwtBuilder jwtBuilder = Jwts.builder();

        //设置官方规定的字段，根据需求设置
        jwtBuilder.setIssuer("曹晨磊");//令牌颁发者
        jwtBuilder.setIssuedAt(new Date());//令牌颁发时间
        jwtBuilder.setAudience("不知名的客户端");//令牌接收者
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + 3600000));//令牌过期时间，1小时以后
        jwtBuilder.setId(UUID.randomUUID().toString());//设置令牌编号

        //设置签名算法和密钥（盐）
        jwtBuilder.signWith(SignatureAlgorithm.HS256, "123456789abcdefg");

        //设置自定义的字段，根据需求设置
        Map<String, Object> claims = new HashMap<>();
        claims.put("age", 24);
        claims.put("money", 1234);
        jwtBuilder.addClaims(claims);

        //生成一个token令牌
        String token = jwtBuilder.compact();
        System.out.println(token); //eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiLmm7nmmajno4oiLCJpYXQiOjE2MjMxNjIxOTAsImF1ZCI6IuS4jeefpeWQjeeahOWuouaIt-erryIsImV4cCI6MTYyMzE2NTc5MCwianRpIjoiNjFlNWJlNjItNmFhOS00ZjYyLWJkOTEtMTE5ODExYjk2ZDFkIiwibW9uZXkiOjEyMzQsImFnZSI6MjR9.fTRvTyEaM1gYNwGmrJ9ADXjHmDD2hI0lvzJKr8d4n-E


    }

    /**
     *           解析token
     */
    @Test
    public void test02(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiLmm7nmmajno4oiLCJpYXQiOjE2MjMxNjIxOTAsImF1ZCI6IuS4jeefpeWQjeeahOWuouaIt-erryIsImV4cCI6MTYyMzE2NTc5MCwianRpIjoiNjFlNWJlNjItNmFhOS00ZjYyLWJkOTEtMTE5ODExYjk2ZDFkIiwibW9uZXkiOjEyMzQsImFnZSI6MjR9.fTRvTyEaM1gYNwGmrJ9ADXjHmDD2hI0lvzJKr8d4n-E";
        Claims body = Jwts.parser().setSigningKey("123456789abcdefg").parseClaimsJws(token).getBody();
        System.out.println(body); //{iss=曹晨磊, iat=1623162190, aud=不知名的客户端, exp=1623165790, jti=61e5be62-6aa9-4f62-bd91-119811b96d1d, money=1234, age=24}

    }


    /**
     *  BASE64加解密
     */
    @Test
    public void test04(){
            byte[] bytes = "Hello,World".getBytes();

            bytes = Base64.getEncoder().encode(bytes);
            System.out.println("编码后：" + new String(bytes));

            bytes = Base64.getDecoder().decode(bytes);
            System.out.println("解码后：" + new String(bytes));
    }

    /**
     * RSA 非对称加密
     */
    @Test
    public void test03(){
        // 定义密钥
        String secret = "123456";

        // 固定格式
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecureRandom secureRandom = new SecureRandom(secret.getBytes());
            keyPairGenerator.initialize(2048, secureRandom);//1024位的RSA密钥基本安全，2048位的密钥极其安全

            // 生成一对公钥和私钥，KeyPair内部就是由PublicKey和PrivateKey组成
            KeyPair keyPair = keyPairGenerator.genKeyPair();

            // 获取公钥并对公钥进行Base64编码（编码后方便查看，你不编码啥都看不懂）
            byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
            publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
            System.out.println("公钥Base64编码后：" + new String(publicKeyBytes));

            // 获取私钥并对私钥进行Base64编码（编码后方便查看，你不编码啥都看不懂）
            byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
            privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
            System.out.println("私钥Base64编码后：" + new String(privateKeyBytes));

    }


}
