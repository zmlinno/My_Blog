package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                //添加请求模版
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/editor.md/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/reg.html")
                .excludePathPatterns("/blog_list.html")
                .excludePathPatterns("/blog_content.html")
                .excludePathPatterns("/art/detail")
                .excludePathPatterns("/art/incr-rcount")
                .excludePathPatterns("/user/getuserbyid")
                .excludePathPatterns("/art/listbypage")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/reg");
    }
}

/*
 이 구성 클래스는 주로 인터셉터를 등록하고 어떤 요청이 인터셉트되어야 하는지 및 어떤 것이 인터셉트에서 제외되어야 하는지를 설정하는 데 사용됩니다.
 이는 로그인 인증 및 권한 제어 등을 구현하는 데 매우 유용합니다.
 这个配置类主要用于注册一个拦截器，并设置了哪些请求会被拦截，
 哪些会被排除在拦截之外。这在实现登录认证、权限控制等方面非常有用。


 */