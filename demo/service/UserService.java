package com.example.demo.service;

import com.example.demo.entity.Userinfo;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class  UserService {
    @Resource
    private UserMapper userMapper;
    public int reg(Userinfo userinfo){

        return userMapper.reg(userinfo);
    }
    public Userinfo getUserByName(String username) {
        return userMapper.getUserByName(username);
        //这也是第二节课补充的
    }

//        public Userinfo getUserById(Integer id){
//            return userMapper.getUserById(id);
//
//        }
    public Userinfo getUserById(Integer id){
        return userMapper.getUserById(id);
    }






}
/*
该服务类通过调用对应的 UserMapper 中的方法来实现与数据库的交互，提供了对用户数据的处理功能。

해당 서비스 클래스는 해당 UserMapper의 메서드를 호출하여 데이터베이스와 상호 작용하며 사용자 데이터를 처리하는 기능을 제공합니다.
 */

