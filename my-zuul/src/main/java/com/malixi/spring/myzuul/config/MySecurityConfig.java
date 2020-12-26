package com.malixi.spring.myzuul.config;



import com.malixi.spring.myzuul.service.MyAuthProvider;
import com.malixi.spring.myzuul.service.MyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Collections;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/23 - 21:35
 * @Description: secutiry 配置类
 * @version: 1.0
 */
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {




    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String pass1 = new BCryptPasswordEncoder().encode("123");
        String pass2 = new BCryptPasswordEncoder().encode("123");
        System.out.println("pass1:" + pass1);
        System.out.println("pass2:" + pass2);

        http.
                // 哪些 地址需要登录
                 authorizeRequests()
                // 针对游客请求 全部放行
                .antMatchers("/dispatcher_one/visitor/**").permitAll()
                //所有请求都需要验证
                .anyRequest().authenticated()
                .and()
                //自定义登录页
                //permitAll 给没登录的 用户可以访问这个地址的权限
                .formLogin().loginPage("/login").permitAll()
                // 登录失败 页面
                .failureUrl("/login.html?error")
                // 登录成功跳转的页面
                .defaultSuccessUrl("/dispatcher_one/getHi",true).permitAll()
                // 配置 登录页 的表单name   admin -> 分权限 展示页面
                .passwordParameter("oo")
                .usernameParameter("xx")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                        AuthenticationException exception) throws IOException, ServletException {

                        exception.printStackTrace();
                        // 判断异常信息 跳转不同页面 比如 密码过期重置
                        //request.getRequestDispatcher(request.getRequestURL().toString()).forward(request, response);
                        request.getRequestDispatcher("/UserNpError").forward(request, response);
                        // 记录登录失败次数 禁止登录

                    }
                })

//                .and()
//                .rememberMe()
                .and()
                .sessionManagement()
                // 允许同时登录的 客户端有几个
                .maximumSessions(1)
                // 已经有用户登录后， 不允许相同用户再次登录
                .maxSessionsPreventsLogin(true)
                .and()
                .and()
                .csrf()
                .csrfTokenRepository(new HttpSessionCsrfTokenRepository());
    }


    // session 登录  并发量高 -> jwt

    /**
     * 直接使用user对象
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         // 内存式的构建用户信息
//        auth.
//                inMemoryAuthentication()
//                .withUser("123").password(new BCryptPasswordEncoder().encode("123")).roles("admin")
//                .and()
//                .withUser("321").password("321").roles("user")
//        ;
        // NoOpPasswordEncoder.getInstance() 不加密直接使用明文
         //auth.userDetailsService(myDetailService()).passwordEncoder(NoOpPasswordEncoder.getInstance());
         auth.userDetailsService(myDetailService())
                 .and()
                 //账号密码 验证
         .authenticationProvider(myAuthProvider())
         ;

    }

    /**
     * 自定义user对象 存内存里面的模式 内存的不用
     * 基于数据库的 需要实现这个接口
     * @return
     */

    //
//    @Autowired
//    private DataSource dataSource;
//    @Bean
//    public UserDetailsService userDetailsService() {
//        // 基于内存的
////        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////        User user = new User("123", new BCryptPasswordEncoder().encode("123"), true, true, true, true, Collections.singletonList(new SimpleGrantedAuthority("xx")));
////        manager.createUser(user);
////        manager.createUser(User.withUsername("malixi").password(new BCryptPasswordEncoder().encode("xx")).roles("xxz").build());
//       // 基于数据库的
//       JdbcUserDetailsManager manager=new JdbcUserDetailsManager(dataSource);
//
//        //利用自带的api创建用户等
//       manager.createUser(User.withUsername("malixi").password(new BCryptPasswordEncoder().encode("111")).roles("admin","xxoo").build());
//        return manager;
//    }


    /**
     * 开启加密
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    MyDetailService myDetailService(){
        System.out.println("初始化myDetailService");
        return new MyDetailService();
    }


    @Bean
    MyAuthProvider myAuthProvider(){
        System.out.println("初始化myAuthProvider");
        return new MyAuthProvider();
    }
}
