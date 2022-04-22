package com.example.davinci.controller;

import com.example.davinci.entity.User;
import com.example.davinci.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String root(){
        return "index.html";
    }
    @RequestMapping("/toLogin")
    public String toLogin(Map<String,Object> map){
        map.put("user",new User());
        return "login";
    }
    @RequestMapping("/reqister")
    public String register(@Valid User user, BindingResult bindingResult,HttpServletResponse response) throws IOException {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        } else {
            userService.addUser(user);
            response.getWriter().write("<script>alert('注册成功!即将前往登录。');window.location='login'; </script>");
            return "redirect:/security/toLogin";
        }
//        String username =request.getParameter("username");
//        String email=request.getParameter("email");
//        String password=request.getParameter("password");
//        User userEntity= new User();
//        userEntity.setUserEmail(email);
//        userEntity.setUserName(username);
//        userEntity.setUserPwd(password);
//        userService.addUser(userEntity);
//        response.getWriter().write("<script>alert('注册成功!即将前往登录。');window.location='login'; </script>");
//        return "redirect:/security/toLogin";
    }
        @PostMapping("/login")
        public String login (User user, Map < String, Object > map){
            if (userService.loadUserByEmail(user.getUserEmail()) != null) {
                List<User> lus = userService.loadUserByEmail(user.getUserEmail());
                if (lus.get(0).getUserPwd().equals(user.getUserPwd())) {
                    map.put("user", lus.get(0));
                    return "index.html";
                }
            }
            return "login";
        }
    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/security/toLogin";
    }
}
