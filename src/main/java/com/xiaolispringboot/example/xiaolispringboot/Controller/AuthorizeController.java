package com.xiaolispringboot.example.xiaolispringboot.Controller;

import com.xiaolispringboot.example.xiaolispringboot.Provider.GitHubProvider;
import com.xiaolispringboot.example.xiaolispringboot.Service.UserService;
import com.xiaolispringboot.example.xiaolispringboot.dto.AccesstokenDTO;
import com.xiaolispringboot.example.xiaolispringboot.dto.GithubUser;
import com.xiaolispringboot.example.xiaolispringboot.mapper.UserMapper;
import com.xiaolispringboot.example.xiaolispringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;
    @Autowired
    private UserService userService;
    @Value("${github.client.id}")
    private  String clientId;
    @Value("${github.client.secret}")
    private String clientSercret;
    @Value("${github.redirect.uri}")
    private  String redirectUri;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code",defaultValue = "00") String code ,
                           @RequestParam(name="state") String state,
                           HttpServletRequest httpRequest,
                           HttpServletResponse httpResponse){
        System.out.println(httpRequest.getServletPath());
        System.out.println(httpRequest.getQueryString());
        AccesstokenDTO accesstokenDTO=new AccesstokenDTO();
        accesstokenDTO.setCode(code);
        accesstokenDTO.setRedirect_uri(redirectUri);
        accesstokenDTO.setState(state);
        accesstokenDTO.setClient_id(clientId);
        accesstokenDTO.setClient_secret(clientSercret);
        String accessToken=gitHubProvider.getAccessToken(accesstokenDTO);
        GithubUser githubUser = gitHubProvider.getUser(accessToken);
        if (githubUser!=null){
            System.out.println("登录成功");
            User user=new User();
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            String token=UUID.randomUUID().toString();
            user.setToken(token);
            user.setGmtCreat(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreat());
            userService.Insert(user);
            //userMapper.Insert(user);
            httpResponse.addCookie(new Cookie("token",token));
            //httpRequest.getSession().setAttribute("User",githubUser);
            return "redirect:/";
        }else{
            System.out.println("登录失败");
            return "redirect:/";
        }
    }



}
