package com.xiaolispringboot.example.xiaolispringboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")//不输入任何东西时的默认返回页面
    public  String index(){
        return "index";
    }
}
