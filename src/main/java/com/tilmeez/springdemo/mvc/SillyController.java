package com.tilmeez.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

    @RequestMapping("/processFormVersionThree")
    public String displayForm() {
        return "silly";
    }
}
