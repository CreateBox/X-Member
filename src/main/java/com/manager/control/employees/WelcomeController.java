package com.manager.control.employees;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @RequestMapping("/welcome.html")
    public String welcome() {
        return "welcome";
    }
}
