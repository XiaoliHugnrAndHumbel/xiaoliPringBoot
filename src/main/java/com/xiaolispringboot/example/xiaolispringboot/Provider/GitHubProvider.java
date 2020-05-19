package com.xiaolispringboot.example.xiaolispringboot.Provider;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.xiaolispringboot.example.xiaolispringboot.dto.AccesstokenDTO;
import com.xiaolispringboot.example.xiaolispringboot.dto.GithubUser;
import jdk.nashorn.internal.parser.JSONParser;
import okhttp3.*;
import org.springframework.stereotype.Component;
import sun.awt.geom.AreaOp;

@Component //把对象实例化放到池子里，
public class GitHubProvider {
    public String getAccessToken(AccesstokenDTO accesstokenDTO){
         MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accesstokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string=response.body().string();

            System.out.println("String:"+string);
            String token=string.split("&",2)[0].split("=")[1];
            System.out.println("String:"+token);
            return token;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response=client.newCall(request).execute();
            String string=response.body().string();
            GithubUser githubUser=JSON.parseObject(string,GithubUser.class);
            return githubUser;
        }catch (Exception e){

        }
        return null;

    }
}
