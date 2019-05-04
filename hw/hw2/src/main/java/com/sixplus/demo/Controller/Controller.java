package com.sixplus.demo.Controller;

import com.sixplus.demo.Response;
import com.sixplus.demo.WordLadder;
import org.springframework.web.bind.annotation.*;


import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = {"*","null"})
@RestController
public class Controller {
    private final AtomicLong counter = new AtomicLong();

    @PostMapping(value = "/wordladder/{start}/{dest}")
    public Response callWordLadder(@PathVariable(value = "start") String start,
                                   @PathVariable(value = "dest") String dest)
    {
        WordLadder wordLadder = new WordLadder(start, dest);
        Response response = new Response(counter.incrementAndGet(),start,dest,wordLadder.doFind());
        return response;
    }

}
