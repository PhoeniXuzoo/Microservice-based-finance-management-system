package cn.phoenixuzoo.oauth2service.controller;

import cn.phoenixuzoo.oauth2service.service.UserService;
import cn.phoenixuzoo.oauth2service.client.AccountServiceClient;
import cn.phoenixuzoo.oauth2service.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountServiceClient accountServiceClient;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String Register() { return "register"; }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/register")
    @ResponseBody
    public String doRegister(User user){
        // 此处省略校验逻辑
        if (userService.create(user))
            return "success";
        return "fail";
    }

    @RequestMapping(value = "/user/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }

}