package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Userinfo {


    //사용자 정보 저장
    //实体类
    //本质上就是一个对象
//    private int id;
    private Integer id;
    //到底用哪个呢。建议使用Integer，因为它的功能很多
    //兼容性比int要好。
    private String username;
    private String password;
    private String photo;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private Integer state;


}


    //那么实体类就有了
    //就去写Mapper

/*
此实体类用于存储用户的基本信息，如用户名、密码、创建时间等。
在数据库中通常会有相应的表与之对应，可以在相关的数据访问类中定义相应的方法来操作这些数据。

이 엔터티 클래스는 사용자의 기본 정보인 사용자 이름, 비밀번호, 생성 시간 등을 저장하기 위해 사용됩니다. 일반적으로 데이터베이스에는 해당 정보와 대응하는 테이블이 있으며,
관련된 데이터 액세스 클래스에서 해당 데이터를 조작하기 위한 메서드를 정의할 수 있습니다.
 */