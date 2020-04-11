package com.leyou.auth.test;

import com.leyou.common.pojo.UserInfo;
import com.leyou.common.utils.JwtUtils;
import com.leyou.common.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {

//    private static final String pubKeyPath = "d:\\tmp\\rsa\\rsa.pub";
//
//    private static final String priKeyPath = "d:\\tmp\\rsa\\rsa.pri";
//
//    private PublicKey publicKey;
//
//    private PrivateKey privateKey;
//
//    @Test
//    public void testRsa() throws Exception {
//        RsaUtils.generateKey(pubKeyPath, priKeyPath, "567");
//    }
//
//    @Before
//    public void testGetRsa() throws Exception {
//        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
//        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
//    }
//
//    @Test
//    public void testGenerateToken() throws Exception {
//        // 生成token
//        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
//        System.out.println("token = " + token);
//    }
//
//    @Test
//    public void testParseToken() throws Exception {
//        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU4NDExNTY1NH0.phkaQ-Z8Uxe9ENZ-j6v73cqYoXvvmr0LPa-WwzVJE0MCANzht9JnfDyIZZZ3gKiUspR7OgHrx0ywmpvbNexNeGqoZvy3TYVIGqNduhZaD8RBFWjf1PKw0laTS10qJZ-HQNrGIqqYmos0qjJ38FsK7AB5-0rK3SDQZ3Qtpii8pJw";
//
//        // 解析token
//        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
//        System.out.println("id: " + user.getId());
//        System.out.println("userName: " + user.getUsername());
//    }
}