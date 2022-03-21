package org.zerok.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerok.domain.SampleVO;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String sayHello()   {
        return "hello world!";
    }

    @GetMapping("sample")
    public SampleVO makesample(){

        SampleVO vo = new SampleVO();
        vo.setVal1("v1");
        vo.setVal2("v2");
        vo.setVal3("v3");

        System.out.println(vo);

        return vo;
    }
}
