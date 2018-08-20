package com.lottery.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LotteryControl {
    @RequestMapping("/")
    public String losthost() {
        return "index";
    }

    @RequestMapping("/{path}")
    public String lottery(@PathVariable("path") String path) {
        return path;
    }
}
