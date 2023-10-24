package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;
@Data
//实体类写完后去AMapper里面定义方法
public class Articleinfo {
    private Integer id;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updatetime;
    private Integer uid;
    private Integer rcount;
    private Integer state;
//글 정보 저장




}

/*
此实体类用于存储与文章相关的信息，例如标题、内容、创建时间等。
在数据库中通常会有相应的表与之对应，可以在 AMapper 类中定义相应的方法来操作这些数据。


이 엔터티 클래스는 제목, 내용, 생성 시간 등과 관련된 기사 정보를 저장하는 데 사용됩니다. 일반적으로 데이터베이스에는 이와 대응하는 테이블이 있으며,
AMapper 클래스에서 이러한 데이터를 조작하기 위한 관련 메서드를 정의할 수 있습니다.
 */