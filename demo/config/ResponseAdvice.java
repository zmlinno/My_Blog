package com.example.demo.config;
import com.example.demo.common.AjaxResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//题目意思是增强的返回
//实现统一数据返回的保底类
//在返回数据之前，检测数据的类型是否为统一的对象，如果不是，封装成统一的对象
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;


    //其实这就是一个开关相当于，
    //如果是true就会调用beforeBodyWrite
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }


    /**
     * 对数据格式进行效验和封装
     */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if(body instanceof AjaxResult) return body;
        if(body instanceof String){
            //需要自行转换成
            return objectMapper.writeValueAsString(AjaxResult.success(body));

        }
        return AjaxResult.success(body);
        //这个类作用就是保底的格式统一
        //最后一个代码是保底机制，保证对象出去肯定是同一个类型
    }





}

/*
이 클래스는 데이터를 반환하기 전에 데이터를 처리하여 반환된 데이터 형식이 통일된 요구 사항을 충족하는지 확인하는 응답 본문 강화기입니다.
这个类是一个响应体增强器，用于在返回数据之前对数据进行处理，确保返回的数据格式符合统一的要求。
 */
