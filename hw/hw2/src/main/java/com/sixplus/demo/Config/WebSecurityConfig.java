package com.sixplus.demo.Config;

import com.sixplus.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
@Order(value = 1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/","/register").permitAll()
                .antMatchers("/wordladder").hasAuthority("USER")
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                .clearAuthentication(true).permitAll()
//                .and()
//                .requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests()
//                .anyRequest().hasAuthority("ADMIN")
//                .and()
//                .httpBasic()
                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .csrf().disable();
        http.addFilterAt(customJSONLoginFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    private CustomJSONLoginFilter customJSONLoginFilter(){
        CustomJSONLoginFilter customJSONLoginFilter = new CustomJSONLoginFilter("/login",userService);
        customJSONLoginFilter.setAuthenticationFailureHandler(new CustomAuthenticationFailureHandler());
        customJSONLoginFilter.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler());
        return customJSONLoginFilter;
    }

}
