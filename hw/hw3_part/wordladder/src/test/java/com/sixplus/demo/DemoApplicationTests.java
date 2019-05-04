//package com.sixplus.demo;
//
//import com.alibaba.fastjson.JSONObject;
//import com.sixplus.demo.Entity.User;
//import org.hamcrest.CoreMatchers;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DemoApplicationTests {
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext wac;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Before
//    public void setup(){
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).apply(springSecurity()).build();
//    }
//
//    @Test
//    public void testRegister() throws Exception{
//        /*
//         do get
//         */
//        MvcResult mvcResult1 = mockMvc
//                .perform(MockMvcRequestBuilders.get("/register"))
//                .andReturn();
//        int status1 = mvcResult1.getResponse().getStatus();
//        String resp1 = mvcResult1.getResponse().getContentAsString();
//
//        Assert.assertEquals("请求错误",200,status1);
//        Assert.assertEquals("返回结果不一致","register",resp1);
//        /*
//         do post
//         */
//        User user = new User();
//        if(userRepository.findByUsername("admin")!=null){
//            userRepository.deleteById(userRepository.findByUsername("admin").getId());
//        }
//        user.setUsername("admin");
//        user.setPassword("admin");
//        user.setNickname("admin");
//        String requestJson = JSONObject.toJSONString(user);
//        MvcResult mvcResult2 = mockMvc
//                .perform(MockMvcRequestBuilders.post("/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestJson))
//                .andReturn();
//        int status2 = mvcResult2.getResponse().getStatus();
//        String resp2 = mvcResult2.getResponse().getContentAsString();
//
//        Assert.assertEquals(200,status2);
//        Assert.assertEquals("{\"code\":\"0\",\"message\":\"success\",\"result\":\"注册成功\"}",resp2);
//
//    }
//
//    @Test
//    public void testWordladder() throws Exception{
//        User user = userRepository.findByUsername("admin");
//        String requestJson = JSONObject.toJSONString(user);
//        MvcResult mvcResult1 = mockMvc
//                .perform(MockMvcRequestBuilders.post("/login")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(requestJson))
//                .andReturn();
//        Assert.assertEquals(200,mvcResult1.getResponse().getStatus());
//        Assert.assertEquals("{\"code\":\"0\",\"message\":\"success\",\"result\":\"登录成功\"}",mvcResult1.getResponse().getContentAsString());
//        MvcResult mvcResult2 = mockMvc
//                .perform(MockMvcRequestBuilders.post("/wordladder/hello/world")
//                )
//                .andReturn();
//        int status2 = mvcResult2.getResponse().getStatus();
//        String resp2 = mvcResult2.getResponse().getContentAsString();
//
//        Assert.assertEquals(200,status2);
//        Assert.assertThat(resp2, CoreMatchers.containsString("Found Ladder"));
//
//        MvcResult mvcResult3 = mockMvc
//                .perform(MockMvcRequestBuilders.post("/wordladder/bee/world")
//                )
//                .andReturn();
//        int status3 = mvcResult3.getResponse().getStatus();
//        String resp3 = mvcResult3.getResponse().getContentAsString();
//
//        Assert.assertEquals(200,status3);
//        Assert.assertThat(resp3, CoreMatchers.containsString("No Ladder"));
//    }
//    @Test
//    public void testActuator() throws Exception
//    {
//        //测试未登录时/management的访问权限
//        MvcResult mvcResult2 = mockMvc
//                .perform(MockMvcRequestBuilders.get("/management")
//                )
//                .andReturn();
//        int status2 = mvcResult2.getResponse().getStatus();
//        Assert.assertEquals(HttpStatus.UNAUTHORIZED.value(),status2);
//        //测试shutdown
//        MvcResult mvcResult3 = mockMvc
//                .perform(MockMvcRequestBuilders.get("/management/shutdown")
//                )
//                .andReturn();
//        int status3 = mvcResult3.getResponse().getStatus();
//        Assert.assertEquals(HttpStatus.NOT_FOUND.value(),status3);
//    }
//}
