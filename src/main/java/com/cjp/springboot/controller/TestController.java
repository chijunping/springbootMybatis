package com.cjp.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class TestController {

    //http://localhost:8080/testFormParams?aa={"aa":"123"}&bb=andriod
    @RequestMapping("testFormParams")
    public Map testFormParams(HttpServletRequest request) {
        //HttpServletRequest.getParameterMap()可同时取get、post参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue()[0]);
        }
        return parameterMap;
    }
}
