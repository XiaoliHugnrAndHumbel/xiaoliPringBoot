package com.xiaolispringboot.example.xiaolispringboot.Controller;

import com.xiaolispringboot.example.xiaolispringboot.Service.UserService;
import com.xiaolispringboot.example.xiaolispringboot.mapper.UserMapper;
import com.xiaolispringboot.example.xiaolispringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @GetMapping("/")//不输入任何东西时的默认返回页面
    public  String index(HttpServletRequest httpServletRequest){
        Cookie[] cookies=httpServletRequest.getCookies();
        if (cookies!=null){
            for(Cookie cookie :cookies){
                if (cookie.getName().equals("token")){
                    String token= cookie.getValue();
                    User user =userService.Select(token);
                    if (user !=null){
                        System.out.println(user);
                        httpServletRequest.getSession().setAttribute("User",user);
                    }
                    else{
                        System.out.println("空的");
                    }
                    break;
                }
            }
        }

        return "index";
    }
}
