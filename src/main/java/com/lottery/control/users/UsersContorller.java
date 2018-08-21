package com.lottery.control.users;

import com.lottery.pojo.Users;
import com.lottery.service.users.UsersService;
import com.lottery.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersContorller {
    @Resource
    private UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object loginajax(HttpSession session, Users users) {
        Map<String, String> map = new HashMap<>();
        Users user = usersService.getUser(users);
        if (user != null) {
            String pwd = MD5Util.EncoderByMd5(users.getPassword());
            if (pwd.equals(user.getPassword())) {
                session.setAttribute("loginUser", user);
                user.setLastLoginTime(new Date());
                user.setLoginCount(user.getLoginCount()+1);
                usersService.alterUser(user);
            } else {
                map.put("msg", "false");
            }
        } else {
            map.put("msg", "null");
        }
        return map;
    }

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/userOut")
    public String userOut(HttpSession session) {
        session.invalidate();
        return "login";
    }

}
