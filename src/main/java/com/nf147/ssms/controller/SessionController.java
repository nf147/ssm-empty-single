package com.nf147.ssms.controller;

import org.apache.shiro.authz.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login () {
        return "please input your password.";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/policy/view")
    //@RequiresPermissions("policy:read")
    @RequiresAuthentication
    @RequiresUser
    @RequiresGuest
    @RequiresPermissions({"policy:read", "policy:write"})
    public String policy () {
        return "dangdezhengcehao,nianianchidebao.";
    }

    @GetMapping("/xxx")
    @RequiresRoles("president")
    public String xxx () {
        return "启动核按钮!";
    }
}
