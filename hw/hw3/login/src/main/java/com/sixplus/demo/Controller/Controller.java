package com.sixplus.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sixplus.demo.Bean.WebResponse;
import com.sixplus.demo.Entity.User;
import com.sixplus.demo.JWT.CustomJWT;
import com.sixplus.demo.Repository.UserRepository;
import com.sixplus.demo.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = {"*","null"})
@RestController
@AllArgsConstructor
public class Controller {
    private UserService userService;
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = "/register")
    public String register(){
        return "register";
    }

    @PostMapping(value = "/register")
    public WebResponse doRegister(@RequestBody User user){
        userService.insert(user);
        return WebResponse.success("注册成功");
    }
    @PostMapping(value = "/login")
    public WebResponse login(HttpServletRequest httpServletRequest){
        System.out.println("here");
        JSONObject requestBody = getRequestBody(httpServletRequest);
        String username = requestBody.getString("username");
        String password = requestBody.getString("password");
        if (userRepository.findByUsername(username) != null && userRepository.findByUsername(username).getPassword().equals(password)) {
            String token = CustomJWT.generateToken(username);
            JSONObject body = new JSONObject();
            body.put("token",token);
            return WebResponse.success(body);
        }
        return WebResponse.success("invalid user");
    }
    private JSONObject getRequestBody(HttpServletRequest request){
        try{
            StringBuilder stringBuilder = new StringBuilder();
            InputStream inputStream = request.getInputStream();
            byte[] bs = new byte[StreamUtils.BUFFER_SIZE];
            int len;
            while ((len=inputStream.read(bs))!=-1){
                stringBuilder.append(new String(bs,0,len));
            }
            return JSON.parseObject(stringBuilder.toString());
        }catch (IOException e){
            System.out.println(e.getMessage());
            return new JSONObject();
        }
    }

}
