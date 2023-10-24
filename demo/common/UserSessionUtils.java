package com.example.demo.common;


import com.example.demo.entity.Userinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//这是一个工具集
//和当前登陆用户相关的操作
public class UserSessionUtils {
    public static Userinfo getUser(HttpServletRequest request){
        //得到当前的登陆用户
        HttpSession session = request.getSession(false);
        if(session!=null &&
                session.getAttribute(AppVariable.USER_SESSION_KEY)!=null){
            //说明用户已经正常登陆了
            return (Userinfo) session.getAttribute(AppVariable.USER_SESSION_KEY);
        }
        return null;

    }
}

/*
이 클래스는 현재 로그인한 사용자 정보를 가져오는 유틸리티 메서드를 제공합니다.
이 기능을 구현하기 위해 HttpServletRequest 객체를 전달합니다.

这个类提供了一个用于获取当前登录用户信息的工具方法，
通过传入 HttpServletRequest 对象来实现这一功能。
 */