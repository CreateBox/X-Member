package com.lottery.control.users;

import com.lottery.pojo.Users;
import com.lottery.service.users.UsersService;
import com.lottery.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UsersContorller {
    @Resource
    private UsersService usersService;

    @RequestMapping("/login")
    public ModelAndView login(HttpSession session, Users users) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        if (null != users.getName()) {
            Users user = usersService.getUser(users);
            if (user != null) {
                String pwd = MD5Util.EncoderByMd5(users.getPassword());
                if (pwd.equals(user.getPassword())) {
                    session.setAttribute("loginUser", user);
                    mv.setViewName("index");
                } else {
                    mv.addObject("msg", "密码不正确，请重新输入");
                }
            } else {
                mv.addObject("msg", "账号不存在，请重新输入");
            }
        }
        return mv;
    }

    @RequestMapping("/userOut")
    public String userOut(HttpSession session) {
        session.invalidate();
        return "login";
    }

}
