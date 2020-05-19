package com.xiaolispringboot.example.xiaolispringboot.Controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.xml.internal.fastinfoset.tools.FI_StAX_SAX_Or_XML_SAX_SAXEvent;
import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;
import com.xiaolispringboot.example.xiaolispringboot.Provider.GitHubProvider;
import com.xiaolispringboot.example.xiaolispringboot.dto.AccesstokenDTO;
import com.xiaolispringboot.example.xiaolispringboot.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.image.PackedColorModel;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;
    @Value("${github.client.id}")
    private  String clientId;
    @Value("${github.client.secret}")
    private String clientSercret;
    @Value("${github.client.uri}")
    private  String redirectUri;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccesstokenDTO accesstokenDTO=new AccesstokenDTO();
        accesstokenDTO.setCode(code);
        accesstokenDTO.setRedirect_uri(redirectUri);
        accesstokenDTO.setState(state);
        accesstokenDTO.setClient_id(clientId);
        accesstokenDTO.setClient_secret(clientSercret);
        String accessToken=gitHubProvider.getAccessToken(accesstokenDTO);
        GithubUser githubUser = gitHubProvider.getUser(accessToken);
        System.out.println(githubUser.getId());
        return "index";
    }
}
