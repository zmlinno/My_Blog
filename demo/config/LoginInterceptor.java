package com.example.demo.config;

import com.example.demo.common.AppVariable;
import com.example.demo.entity.Userinfo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {



    //当返回是true的时候，用户已登陆
    //false 用户未登陆
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if(session!=null && session.getAttribute(AppVariable.USER_SESSION_KEY)!=null){

            //用户已登陆
            System.out.println("当前登陆用户为:"+
                    ((Userinfo)session.getAttribute(AppVariable.USER_SESSION_KEY)).getUsername());
            return true;
        }
        //未登陆要转到登陆页面
        response.sendRedirect("/login.html");
        //这样的话普通拦截器就写完了
        return false;

    }
}

/*
이 클래스는 사용자의 로그인 상태를 확인하기 위해 구현된 인터셉터입니다.
사용자가 이미 로그인한 경우 요청을 계속 처리하고, 그렇지 않은 경우 로그인 페이지로 리디렉션됩니다.

这个类实现了一个拦截器，用于检查用户的登录状态。
如果用户已经登陆，将会继续处理请求，否则将会重定向到登录页面。
 */
