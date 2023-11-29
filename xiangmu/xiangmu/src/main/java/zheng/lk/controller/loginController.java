package zheng.lk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zheng.lk.enter.loginEnter;
import zheng.lk.service.loginService;

import java.util.List;

@RestController
@RequestMapping("login")
public class loginController {


    @Autowired
    loginService service;

    @GetMapping("get")
    public String get(){

        System.out.println("收到了消息");
        return "ok";
    }

    @GetMapping("getpage")
    public List<loginEnter> getpage(){
        List<loginEnter> getpage = this.service.getpage();
        System.out.println("密码账户已输出");
        System.out.println(getpage);
        return getpage;
    }

    @PostMapping("check")
    public boolean check(String username,String password){

        return false;
    }
}
