package cn.fqfx.GoodByeFQFX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController
{
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin()
    {
        return "admin_login";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
}
