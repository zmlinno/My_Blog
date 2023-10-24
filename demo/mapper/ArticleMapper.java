package com.example.demo.mapper;

import com.example.demo.entity.Articleinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ArticleMapper {

    int getArtCountByUid(@Param("uid") Integer uid);

    List<Articleinfo> getMyList(@Param("uid") Integer uid);
    //写完这个在去xml
    //사용자의 글 목록


    //这是从删除前端过来的写后端的第一步

    int del(@Param("id") Integer id,@Param("uid") Integer uid);
    //写完这一步然后转到xml,
    //写完xml在去写Service
    Articleinfo getDetail(@Param("id") Integer id);

    /////////
    int incrRCount(@Param("id") Integer id);

    int add(Articleinfo articleinfo);

    int update(Articleinfo articleinfo);

    List<Articleinfo> getListByPage(@Param("psize") Integer psize,
                                    @Param("offsize") Integer offsize);

    int getCount();



}
/*
这些方法提供了对文章数据的基本操作，可以在实际应用中使用该接口来访问和管理文章数据。
이러한 메서드들은 기사 데이터에 대한 기본적인 작업을 제공하며,
실제 응용 프로그램에서이 인터페이스를 사용하여 기사 데이터에 액세스하고 관리할 수 있습니다.
 */