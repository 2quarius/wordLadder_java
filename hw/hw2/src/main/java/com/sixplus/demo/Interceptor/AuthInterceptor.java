//package com.sixplus.demo.Interceptor;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.sixplus.demo.JWT.CustomJWT;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class AuthInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object o) throws Exception{
//        try {
//            String token = httpServletRequest.getHeader("token");
//            String username = JWT.decode(token).getClaim("username").asString();
//            JWTVerifier jwtVerifier = CustomJWT.verifyToken(username);
//            jwtVerifier.verify(token);
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//            return false;
//        }
//        return true;
//    }
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception{
//    }
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object o,Exception e) throws Exception{
//    }
//}
//
