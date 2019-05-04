package com.sixplus.demo.Controller;

import com.sixplus.demo.Bean.WebResponse;
import com.sixplus.demo.Entity.User;
import com.sixplus.demo.Response;
import com.sixplus.demo.Service.Impl.BaseUserService;
import com.sixplus.demo.Service.UserService;
import com.sixplus.demo.WordLadder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = {"*","null"})
@RestController
@AllArgsConstructor
public class Controller {
    private UserService userService;
    private final AtomicLong counter = new AtomicLong();


    @GetMapping(value = "/register")
    public String register(){
        return "register";
    }

    @PostMapping(value = "/register")
    public WebResponse doRegister(@RequestBody User user){
        userService.insert(user);
        return WebResponse.success("注册成功");
    }
    @PostMapping(value = "/wordladder/{start}/{dest}")
    public Response callWordLadder(@PathVariable(value = "start") String start,
                                   @PathVariable(value = "dest") String dest)
    {
        WordLadder wordLadder = new WordLadder(start, dest);
        Response response = new Response(counter.incrementAndGet(),start,dest,wordLadder.doFind());
        return response;
    }

}
