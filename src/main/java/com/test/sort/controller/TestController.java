package com.test.sort.controller;

import com.alibaba.fastjson.JSON;
import com.test.sort.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        new SpringLoggingHelper().helpMethod();
        return "index";
    }

    @RequestMapping("helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping("sort")
    public String sort(){
        Map<String,String> result = new HashMap<>();
        int n[] = new int[100000];
        for (int i = 0; i < 100000; i++) {
            n[i] = (int) (Math.random() * 100);
        }
//        result.put("排序数组", JSON.toJSONString(n));
        result.put("BubbleSort", String.valueOf(BubbleSort.sort(n)));
        result.put("QuickSort", String.valueOf(QuickSort.sort(n)));
        result.put("SelectSort", String.valueOf(SelectSort.sort(n)));
        result.put("InsertSort", String.valueOf(InsertSort.sort(n)));
        return JSON.toJSONString(result);
    }
}
