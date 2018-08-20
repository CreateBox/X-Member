package com.lottery.control.users;

import com.lottery.pojo.Users;
import com.lottery.service.users.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/lottery")
public class UsersContorller {
    @Resource
    private UsersService usersService;

    @RequestMapping("/login")
    public ModelAndView login(HttpSession session, Users users){
        ModelAndView mv = new ModelAndView();
        Users user = usersService.getUser(users);
        if(user!=null){
            if(users.getPassword().equals(user.getPassword())){
                session.setAttribute("loginUser",user);
                mv.setViewName("index");
            }else{
                mv.addObject("msg","密码不正确，请重新输入");
                mv.setViewName("login");
            }
        }else{
            mv.addObject("msg","账号不存在，请重新输入");
            mv.setViewName("login");
        }
        return null;
    }
}
