package com.example.demo.entity.vo;

import com.example.demo.entity.Userinfo;
import lombok.Data;

@Data
public class UserinfoVO extends Userinfo {
    private Integer artCount;//此人发表文章总数
}

/*
用于在显示用户信息时，同时提供了发表文章总数的统计信息

사용자 정보를 표시하면서 게시된 글의 총 수를 제공합니다
 */