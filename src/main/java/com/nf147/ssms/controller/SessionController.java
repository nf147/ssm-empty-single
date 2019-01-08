package com.nf147.ssms.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@RestController
public class SessionController {

    @PostMapping(value = "/login")
    @ResponseBody
    public String login (String username, String password) {
        Subject current = SecurityUtils.getSubject();
        if (!current.isAuthenticated()) {
            current.login(new UsernamePasswordToken(username, password));
            // 签发 jwt
            // 响应给客户端

        }
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
