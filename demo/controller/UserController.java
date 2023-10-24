package com.example.demo.controller;


import com.example.demo.common.AjaxResult;
import com.example.demo.common.AppVariable;
import com.example.demo.common.UserSessionUtils;
import com.example.demo.entity.Userinfo;
import com.example.demo.entity.vo.UserinfoVO;

import com.example.demo.service.ArticleService;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//这是一个注册功能的后端

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("reg")
    public AjaxResult reg(Userinfo userinfo){
        //非空效验和参数有效性效验
        //也可能绕过前端的代码直接来一个非法的请求
        //请求不只有一种方式
        if(userinfo==null || !StringUtils.hasLength(userinfo.getUsername()) ||
                  !StringUtils.hasLength(userinfo.getPassword())){
            return AjaxResult.fail(-1,"非法参数");


        }
        return AjaxResult.success(userService.reg(userinfo));


    }
    @RequestMapping("/login")
    public AjaxResult login(HttpServletRequest request,String username, String password){
        //1.非空效验，比如用户名和密码都没输入，就根本不会查询得到
        if(!StringUtils.hasLength(username)||!StringUtils.hasLength(password)){
            return AjaxResult.fail(-1,"非法请求");
        }
        //2.查询数据库
        Userinfo userinfo = userService.getUserByName(username);
        if(userinfo != null && userinfo.getId()>0){
            //起码这是一个有效的用户名，反之就是一个无效的用户名
            //判断两个密码是否相同
            if(password.equals(userinfo.getPassword())){


                //登陆成功


                //将用户存储到session
                HttpSession session = request.getSession();
                session.setAttribute(AppVariable.USER_SESSION_KEY,userinfo);
                userinfo.setPassword("");//返回前端之前，隐藏敏感密码信息
                return AjaxResult.success(userinfo);
            }
        }
        return AjaxResult.success(0,null);
            //如果是null的话就会自己去判断。
        }




    @RequestMapping("/showinfo")
    public AjaxResult showInfo(HttpServletRequest request) {
        UserinfoVO userinfoVO = new UserinfoVO();
        // 1.得到当前登录用户（从 session 中获取）
        Userinfo userinfo = UserSessionUtils.getUser(request);
        if (userinfo == null) {
            return AjaxResult.fail(-1, "非法请求");
        }
        // Spring 提供的深克隆方法
        BeanUtils.copyProperties(userinfo, userinfoVO);
        // 2.得到用户发表文章的总数
        userinfoVO.setArtCount(articleService.getArtCountByUid(userinfo.getId()));
        return AjaxResult.success(userinfoVO);
    }
    //注销，退出登陆
    @RequestMapping("/logout")
    public AjaxResult logout(HttpSession session){
        session.removeAttribute(AppVariable.USER_SESSION_KEY);
        return AjaxResult.success(1);

    }




    //下面是今天添加的
    @RequestMapping("/getuserbyid")
    public AjaxResult getUserById(Integer id) {
        if (id == null || id <= 0) {
            // 无效参数
            return AjaxResult.fail(-1, "非法参数");
        }
        Userinfo userinfo = userService.getUserById(id);
        if (userinfo == null || userinfo.getId() <= 0) {
            // 无效参数
            return AjaxResult.fail(-1, "非法参数");
        }
        // 去除 userinfo 中的敏感数据，ex：密码
        userinfo.setPassword("");
        UserinfoVO userinfoVO = new UserinfoVO();
        BeanUtils.copyProperties(userinfo, userinfoVO);
        // 查询当前用户发表的文章数
        userinfoVO.setArtCount(articleService.getArtCountByUid(id));
        return AjaxResult.success(userinfoVO);
    }


}
/*
이 컨트롤러는 사용자 등록, 로그인, 정보 표시 및 로그아웃과 같은 사용자 관련 기능을 처리합니다.
 */












