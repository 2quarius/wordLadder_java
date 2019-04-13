package com.sixplus.demo.Config;

import com.sixplus.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Order(value = 0)
public class ActuatorConfig extends WebSecurityConfigurerAdapter {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests()
                .anyRequest().hasAuthority("ADMIN")
                .and()
                .httpBasic();
        http.addFilterAt(customJSONLoginFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    private CustomJSONLoginFilter customJSONLoginFilter(){
        CustomJSONLoginFilter customJSONLoginFilter = new CustomJSONLoginFilter("/login",userService);
        customJSONLoginFilter.setAuthenticationFailureHandler(new CustomAuthenticationFailureHandler());
        customJSONLoginFilter.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler());
        return customJSONLoginFilter;
    }

}
