package com.example.demo.mapper;
import com.example.demo.entity.Userinfo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int reg(Userinfo userinfo);
    //这个方法是进行注册的
    // 更优的写法，建议去传对象
    //创建好唯一约束是我们写这个方法的基础
    //没有这个唯一约束的话，那么同一个用户名就可以创造无数条
    //那么在接收的时候就会报错
    //根据用户名查询user对象
    Userinfo getUserByName(@Param("username") String username);

    ////今天加的
    Userinfo getUserById(@Param("id")Integer id);



}
/*
这些方法提供了对用户数据的基本操作，可以在实际应用中使用该接口来访问和管理用户数据。

이러한 메서드들은 사용자 데이터에 대한 기본 작업을 제공하며,
실제 응용 프로그램에서이 인터페이스를 사용하여 사용자 데이터에 액세스하고 관리할 수 있습니다.
 */
