package com.cong.fishisland.controller.user;


import com.cong.fishisland.config.GitHubConfig;
import io.swagger.annotations.ApiOperation;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping("/oauth")
//@Api(tags = "Github 登录相关")
public class RestAuthController {
    @Resource
    private GitHubConfig gitHubConfig;

    @RequestMapping("/render")
    @ApiOperation(value = "获取GitHub授权地址重定向")
    public void renderAuth(HttpServletResponse response) throws IOException {
        AuthRequest authRequest = gitHubConfig.getAuthRequest();
        response.sendRedirect(authRequest.authorize("fishGithub"));
    }

}
