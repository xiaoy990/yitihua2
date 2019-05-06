package com.xiaoy.user.controller.usercontroller;

import com.xiaoy.user.entity.users.User;
import com.xiaoy.user.service.userservice.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login")
    public String Login(User user, Model model, HttpServletResponse resp) throws IOException {
        Subject subjct = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUser_name(),user.getPassword());
        try {
            subjct.login(token);
        }catch (UnknownAccountException e){
            System.out.println(user.toString());
            System.out.println("调试信息： 用户名不存在");
            model.addAttribute("msg","用户名不存在");
            resp.setContentType("text/text;charset=utf-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            out.println(true);
            return null;
        }catch (IncorrectCredentialsException e){
            System.out.println("调试信息： 密码错误");
            model.addAttribute("msg","密码错误");
            model.addAttribute("msg","用户名不存在");
            resp.setContentType("text/text;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println(false);
            return null;
        }
        return "success";
    }

    @RequestMapping("unAuth")
    public String unAuth(){
        return "unAuth";
    }

    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("register")
    public String register(User user){
        user.setPerms("user.guest");
        userService.addUser(user);
        return "redirect:/user/toLogin";
    }

    @RequestMapping("admin")
    public String administrator(){
        return "admin";
    }
}
