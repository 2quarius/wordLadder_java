//package com.sixplus.demo.JWT;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//
//public class CustomJWT {
//    private static String SIGNATURE = "secret";
//    public static String generateToken(String username)
//    {
//        String token = JWT.create()
//                .withClaim("username",username)
//                .withIssuer("auth")
//                .sign(Algorithm.HMAC256(SIGNATURE));
//        return token;
//    }
//    public static JWTVerifier verifyToken(String username)
//    {
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SIGNATURE))
//                .withClaim("username",username)
//                .withIssuer("auth").build();
//        return jwtVerifier;
//    }
//}
